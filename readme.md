# Hero Squad
A web app to manage heroes, squads (teams) and adding heroes to squads

## Author
* Patrick Karuri

## Project Setup Instructions
Follow the following setup instructions to run the program.
* Install the java software development kit (sdk)
* Install java
* Install gradle
* To run the program in the terminal you can use 'gradle run' command

## Screenshots

### HomePage
![screenshot showing the encrypt process](https://raw.githubusercontent.com/pkariithi/HeroSquad/main/src/main/resources/public/screenshots/1-homepage.png)

## B.D.D

| BEHAVIOUR                                | INPUT                                                           | OUTPUT                                                                                   |
|------------------------------------------|-----------------------------------------------------------------|------------------------------------------------------------------------------------------|
| User visits the squads page              |                                                                 | Users sees the squads list or an an empty message if there are none                      |
| User visits the new squad page           | User enters the name, max size and cause for the new squad      | Users sees the new squad added to the squads list                                        |
| User Visits home page                    |                                                                 | Users sees the landing page                                                              |
| User visits the heroes page              |                                                                 | Users sees the heroes list or an empty message if there are none                         |
| User visits the new hero page            | User enters the name, age, powers and weakness for the new hero | Users sees the new hero added to the heroes list                                         |
| User visits the hero detail page         |                                                                 | Users sees the details of the new user including an empty squad                          |
| User clicks the add hero to squad button |                                                                 | Users sees the details of the hero plus a select dropdown of all squads                  |
| User selects a squad and presses add     | User selects one squad to add the hero to                       | Users sees the details of the hero with the squad field now filled with the squads name  |
| User visits the credits page             |                                                                 | Users sees the various credit entries                                                    |


## Technologies Used
* Intelli J IDEA
* Java
* Gradle
* JUnit
* Git
* HTML
* CSS
* Javascript
* jQuery

## License
Copyright (c) 2021 [MIT LICENSE](./LICENSE)