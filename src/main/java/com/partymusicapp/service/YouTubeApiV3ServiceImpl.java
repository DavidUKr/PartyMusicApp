package com.partymusicapp.service;

import com.partymusicapp.advice.exception.YoutubeSearchListEmptyException;
import com.partymusicapp.models.Song;
import com.partymusicapp.models.mapper.SongMapper;
import com.partymusicapp.models.youtube.YouTubeSearchResponse;
import io.swagger.v3.core.util.Json;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

//AIzaSyB1jhfgHE0GItu4PLzYT-dy-8n5GRYZBPs key for access to Global Data
@Service
@RequiredArgsConstructor
public class YouTubeApiV3ServiceImpl implements YouTubeApiV3Service{

    private final String KEY = "AIzaSyB1jhfgHE0GItu4PLzYT-dy-8n5GRYZBPs";
    private final SongMapper songMapper;
    @Override
    public List<Song> searchSong(String searchInput) {

        String parameters="?part=snippet&q="+searchInput+ "&key=" + KEY;

        YouTubeSearchResponse youTubeSearchResponse=getYouTubeSearchResponse(parameters, "search");

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

    private YouTubeSearchResponse getYouTubeSearchResponse(String parameters, String controller){
        RestTemplate restTemplate=new RestTemplate();

        HttpEntity<String> requestEntity = getStringHttpEntity(parameters);

        ResponseEntity<YouTubeSearchResponse> response=restTemplate.exchange("youtube.googleapis.com/youtube/v3/"+controller, HttpMethod.GET, requestEntity, YouTubeSearchResponse.class);

        return response.getBody();
    }

    private HttpEntity<String> getStringHttpEntity(String parameters) {
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        return new HttpEntity<>(parameters, headers);
    }
}
