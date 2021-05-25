<!-- Table of Contents -->
## Table of Contents
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#i-want-to-have-my-own-pictures-as-background">I want to have my own pictures as background</a></li>
        <li><a href="#building-the-source-code">Building the source code</a></li>
      </ul>
    </li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>

## About The Project
Who doesn't hate the awkward silence at a online course at the beginning. The anticipation when the course will begin or 

## Getting started
1. Click on the green Button with "Code" on the right top of this page and copy the link
2. Clone the repo
   ```sh
   git clone <the link you copied>
   ```
3. say yes to the fingerprint
4. You got the Repo on your PC - \\(owo)/ Yey~

### I want to have my own pictures as background
Then replace the pictures in the [Source-folder](https://github.com/Koraiko/course_countdown/tree/main/Countdown/Source) on your local machine:

You need to rename them in \<number\>.jpg for them to work. 
It should begin with the number 0 and go to the number-1 in the variable "pic_count" (line: 30) in the class [Main.java](https://github.com/Koraiko/course_countdown/blob/main/Countdown/src/Main.java).
So with `int pic_count = 17` you have the pictures *0.jpg* till *16.jpg* in your folder.

The "summer.jpg" and "winter.jpg" files are special ones that will be only printed if you have the months Jan-March or Oct-Dec for winter and the other months for summer.

All pictures are chosen randomly with the season pictures counting as one picture in the algorithm.

### Building the source code
[Gradle](https://gradle.org/) is used as the build tool and helps you to get all neccessary dependencies.
To run the code using the wrapper (no need to install Gradle locally), run ```gradlew run --args='-h 20 -m 50 -s 30'```
where `20`, `50` and `30` are arbitary numbers representing the time at which the timer shall expire.

Running ```gradlew shadowJar``` creates a "fat" jar for you in ```build\libs``` for you that includes all images and dependencies.
This jar can easily be run in different environments or without Gradle.

Notice that running Gradle with invalid arguments for the program gives you a meaningless stack trace instead of a beautiful help text.

## Roadmap

See the [open issues](https://github.com/Koraiko/course_countdown/issues) for a list of proposed features (and known issues).

## Contributing
Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated** if they work.
So please test your Project before pushing it on the master branch.

### Commands
| What  | How |
|--|--|
| Create branch  | `git switch -c feature/<yourBranch>` |
| Commit your Changes |  `git commit -m "what did you do"`|
| Push to the Branch |`git push origin feature/<yourBranch>`|
| update local Repo |`git fetch` & `git rebase`|
|Merge|`git mergetool`|
|pull|`git pull`|

## License
You can use this Project in your University Job or in a non-commercial way outside of your university.
**The License will be updated in the future in a standard-license-thing with a link**.

## Contact
Koko - sarah.marek@uni-ulm.de - [GitHub](https://github.com/Koraiko)
