# Get Strong Toolbox

This web app is a proof of concept only. It aims to provide a way for users to more easily implement various strength
training programs. It does this by creating forms to log workout sessions customized from various programs. The sample
program currently implemented is <a href="https://startingstrength.com/">Starting Strength.</a>

## Required Setup

1) After downloading or forking the repository, start the Spring Boot web app via the GetStrongApplication class in
`src/main/java`.

2) Start the front end application by navigating to `src/main/frontend` in your terminal and then running `npm start`.
This will serve the Angular front end app on http://localhost:4200. Note that usually Angular apps are served with the
`ng serve` command, however, the aforementioned method utilizes a proxy configuration to call the apis via 
http://localhost:8080, the address of the Spring Boot application.


## Limitations

The current implementation is not fully featured. This is merely a starting point to flesh out some ideas and iterate
over. For instance, the front end is not mobile friendly yet. There is not a way to logon to the app and therefore it
is not secure. User's don't have access to their own data and it is not even possible to be created as a new user yet.
These limitations will be addressed moving forward as time and opportunity permit.
