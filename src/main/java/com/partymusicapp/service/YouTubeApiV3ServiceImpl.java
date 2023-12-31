package com.partymusicapp.service;

import com.partymusicapp.advice.exception.YTNotRespondingException;
import com.partymusicapp.advice.exception.YoutubeSearchListEmptyException;
import com.partymusicapp.models.Song;
import com.partymusicapp.models.mapper.SongMapper;
import com.partymusicapp.models.YouTubeSearchResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class YouTubeApiV3ServiceImpl implements YouTubeApiV3Service{

    @Value("${google.api.key}")
    private String KEY;
    private final SongMapper songMapper;

    @Override
    public List<Song> searchSong(String searchInput) {

        String parameters="?part=snippet&q="+searchInput+ "&key=" + KEY;

        YouTubeSearchResponse youTubeSearchResponse;
        try {
            youTubeSearchResponse = getYouTubeSearchResponse(parameters, "search");
        }catch(HttpClientErrorException e){
            // Capture the error message for debugging purposes
            String errorMessage = e.getResponseBodyAsString(); // Get the response body for error details

            // Based on the status code, throw relevant exceptions or handle differently
            if (e.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
                throw new YoutubeSearchListEmptyException("No videos found for the search query.");
            } else {
                throw new YTNotRespondingException("YouTube API responded with an error: " + errorMessage);
            }
        }
        return songMapper.youTubeSearchResponseToSongs(youTubeSearchResponse);
    }

    @Override
    public Song getSongDetails(String songId) throws YoutubeSearchListEmptyException {
        String parameters="?part=snippet%2CcontentDetails%2Cstatistics&id="+songId+"&key="+KEY;

        YouTubeSearchResponse youTubeSearchResponse=getYouTubeSearchResponse(parameters, "videos");

        return songMapper.youTubeSearchResponseToSong(youTubeSearchResponse);
    }

    @Override
    public List<Song> getSongsDetails(List<String> songIds) {
        return null;
    }

    private YouTubeSearchResponse getYouTubeSearchResponse(String parameters, String controller) throws ErrorResponseException{
        RestTemplate restTemplate=new RestTemplate();

        HttpEntity<String> requestEntity = getStringHttpEntity();

        ResponseEntity<YouTubeSearchResponse> response=restTemplate.exchange("https://youtube.googleapis.com/youtube/v3/"+controller+parameters, HttpMethod.GET, requestEntity, YouTubeSearchResponse.class);

        if(!response.getStatusCode().is2xxSuccessful())
        {
            throw new ErrorResponseException(HttpStatus.NO_CONTENT);
        }

        return response.getBody();
    }

    private HttpEntity<String> getStringHttpEntity() {
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        return new HttpEntity<>(headers);
    }
}
