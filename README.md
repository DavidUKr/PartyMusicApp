# PartyMusicApp
WAD project: WEB Application

Description
A WEB application that hosts party music. The main idea is that the music is being controlled by the party attenders, not necessarily the party host/DJ. In this way we add a wildcard to the parties and an element of surprise.
Main Components:
Login/Register Page:
Home page: A place where a user can view his stats, search and follow users, host and join parties.
Party page: Here User can see the song currently being played, see the recommended list, can recommend songs and vote. Also this page hosts a live chat.
	
•	USER:
-	hosts parties
-	jons parties
-	follow others users
-	manages followers
-	see his popularity score
-	-optioanal: post party pictures/stories (snapchat style)
-	PartyGoerUser: 
	Can recommend songs
	Can vote for songs to be played
	Invite Users (if permitted)
-	PartyLeaderUser:
	Creates party session
	Controls music player: start/stop/next/volume/etc.
	Can choose from the recommended list
	Send/Limits Party invites
•	ADMIN:
-	Can delete parties
-	Can ban users
-	Manages database

Optional ideas: Have special modes for parties: karaoke, guess the song…

Technologies used: Java Spring Boot, Angular, Postgres.
