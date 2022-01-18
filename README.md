# Automationtest
Automation test project for Branch Hub



Run with the below command you should be able to see the reports:

** gradle clean -Denv="{env_name}" -Dbrowser="{browser}" -Dtags="{tag_name}" -Dwebdriver.chrome.driver="{driver_location}" test aggregate  **

| Variable Name         | Mandatory/ Optional  | Default Value      | Examples Values             |
| -------------         | ------------------   |----------------    |----------------             |
| env_name              | Optional             | test               | dev, test                   |
| tag_name              | Optional             | All tests will run | Any tag from feature file   |
| driver_location       | Mandatory            | All tests will run | this is the driver location | 
| browser               | Optional             | chrome             | chrome, firefox             | 


Please note:
1. Depending on the env you supply, all the endpoints will be identified and will be used in appropriate places.
2. tag name is case sensitive.
3. Reports will be generated at location 'target/site/serenity/index.html'
