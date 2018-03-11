# HSBCTask

##App can by start by using gradle wrapper. Run CommandLine, go into project directory and type "gradlew bootRun", or "java -jar HSBCTask.jar"

###When application started just open Web Browser and type: "localhost:8080" 

##API
###UserController

    List of all users;
    Mapping: "/users",
    Method: GET,
####

    Start to follow user    
    Mapping: "/users/{username}/follow/{followed}",
    Method: GET,
    Params: {username}(String) name of your user,
            {followed}(String) name of user to follow
            
####

    Start od followed users    
    Mapping: "/users/{username}/followed",
    Method: GET,
    Params: {username}(String) name of your user
    
###MessageController

    List of all messages;
    Mapping: "/messages",
    Method: GET      
####

    List of all messages posted by user(wall);
    Mapping: "/messages/{username}",
    Method: POST,
    Params: {username}(String) name of your user,
    Body: message as string 
####

    Post new message;
    Mapping: "/messages/{username}/add",
    Method: POST,
    Params: {username}(String) name of your user,
    Body: message as string
####

    List of all messages posted by followed users(timeline)
    Mapping: "/messages/{username}/timeline",
    Method: GET,
    Params: {username}(String) name of your user
  