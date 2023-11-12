package com.partymusicapp.models.mapper;

import com.partymusicapp.advice.exception.YoutubeSearchListEmptyException;
import com.partymusicapp.models.Song;
import com.partymusicapp.models.YouTubeSearchResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class SongMapperImpl implements SongMapper{
    @Override
    public List<Song> youTubeSearchResponseToSongs(YouTubeSearchResponse youTubeSearchResponse) {

        List<Song> songs=new ArrayList<Song>();

        for(YouTubeSearchResponse.Item item : youTubeSearchResponse.getItems()){
            if(item.getId().getKind().equals("youtube#video"))
                songs.add(Song.builder()
                        .id(item.getId().getVideoId())
                        .title(item.getSnippet().getTitle())
                        .author(item.getSnippet().getChannelTitle())
                        .source(getSourceFromVideoAndChanelId(item.getId().getVideoId(), item.getSnippet().getChannelId()))
                        .thumbnail(item.getSnippet().getThumbnails().getMedium().toString())
                        .build());
        }

        return songs;
    }

    @Override
    public Song youTubeSearchResponseToSong(YouTubeSearchResponse youTubeSearchResponse) throws YoutubeSearchListEmptyException {
        Optional<Song> optionalSong=youTubeSearchResponseToSongs(youTubeSearchResponse).stream().findFirst();

        return optionalSong.orElseThrow(()->new YoutubeSearchListEmptyException("Could not find any song in response list"));
    }

    private String getSourceFromVideoAndChanelId(String videoId, String chanelId){

        return "https://www.youtube.com/watch?v="+videoId+"&ab_channel="+chanelId;
    }
}
