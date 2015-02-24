
      

        



# Seng371-Project

 BY JORIN WEATHERSTON AND BRANDON LEECH

#Apache-Ant Github Repository and Mail Archive Analysis Project
##Introduction
This project focuses on the Apache-Ant project. The reason we chose this project is because it has both Github data, and publicly available email archives in the form of mbox files. This same project will be able to be run on all other projects which also have these two resources available. 

In this project the goal is to, based on the communications that occur, infer the structure of the company. Connecting this to the commits that occur, with other data in the Github system for the project, we should be able to see who the people are that make the largest impact on the code, who is at the center of communications, and determine if the people who we would expect to be at the helm of a project are represented in the data. 

##Project Question
Our formal project question is as follows:
“Can we determine the hierarchical organization and the social structure within an organization from looking at the codebase and internal communication?”

An example of a situationally specific question is: “Can we see that someone high up in the company has as much influence in the project as their title suggests?”

##Importance
This area of research can reveal a lot about organizational structure, social structure, the effectiveness of different communication styles, and possibly provide credit (or bonuses) to those who have empirically contributed the most to a project’s success. Developers do not often recognize the amount of communication that it takes to properly develop a product, so perhaps this will help a team understand that although a manager may not provide that many lines of code, they still play an integral part in coordinating people.

##Codebases/Systems Analyzed
Apache Ant is the only project that we ran our methodology on, but all open source Apache projects include the same structure and have the same resources available to the public, so there is a massive number of projects that this could be done with from just them. 

##Metrics
Our metrics are selected to provide maximum insight into the interactions of the developers. We also collect the contributions of developers to code. 
* Number of conversations each employee is involved in: Might give us an idea of who the project managers,senior developers, or team leads are.
* Number of commits per developer over time. This combined with the first point could show us which contributors are more technical and which are more in the management or design side of the organization.
* Number of conversations pairs of people have in common: Knowing this could allow us to construct some kind of conversation tree. This could help us determine who the project managers are, who the team leaders are, and could give us an idea of who works with who.
* Knowing who codes together could help us determine the team structure within an organization.

##Leveraged Tools
Our data creation process involves a few major stages that rely on existing toolsets:
* Gource: A tool which looks at the file structure of a repository over time and connects changes to the structure to the developers. This renders a video of a user defined time period of interest. 
* WGET: A linux command line tool that lets you download the contents from a URL.
* Python: A programming language used for conversion of mbox files to csv files.
* Java: A programming language used for parsing the csv files into useable data. 

##Our Tool 
* Download Mbox email files from the apache-ant email archive: We used wget to do this in Linux.
* Unzip the files.
* Convert the mbox files into csvs for parsing: This was done through a Python script we wrote to custom delimit the mbox entries into a two field csv file. Email subject and Email sender (from field). 
* Process the csvs: Our script for this is written in Java (Download EmailParser.java). This is where we ran into our problems because it is extremely hard to parse strings as random as subjects in a software development environment. We go over the areas that caused problems in detail in the issues section.
* Visualize the changes in the code: Gource is an excellent tool that we used in class to see the changes that occurred to the file structure. Github also enables code change visualization through user contributions. 
* Correlate the data: For this we would generate graphs in excel/calc to see what kinds of connections can be made between the communication, social, and organizational structures, and then tie this in with contributions to the code. We would want to, for example, be able to predict the formal structure of the organization from the communications. We can check these results with the staff/contributors lists found online.

##Results
While processing 66000+ emails we were able to clearly pick out some of the major contributors of Apache Ant. Some specific names seemed to show up a lot, and some were sent by the same person 10 years apart. One of these people is Stefan Bodewig who can be found near the top of the list of the Project Management Committee on the Apache Ant project site. 

We were not able to prepare final data into a form that we could draw further results from. Our issues are detailed below.

##Analysis of Results/Issues
In our process of collecting and parsing data we hit some major hurdles. This has essentially stopped us from being able to fully report our findings. While through simple observation of individuals and their frequent participation in both emails and github contributions it is possible to see that in some cases the people who communicate most frequently do also contribute to code a lot too. But this is not something which we have found through data analysis. 

Our stopping issue was parsing of the csvs that we generated in the 3rd step in our Tools section. The email subjects for developers contain many characters that most people would not include anywhere else. Our plan was to use regular expressions to parse the strings of subject/from pairs, but there are escaped characters, regular expressions, and all manner of reserved characters in use when developers email one another. This means that the parser crashes for a massive number of special cases and scenarios. This is exacerbated by our data spanning 15 years on a large project, and would only get worse for larger projects. 

Moving forward a different approach for rendering our data useful needs to be adopted if we are to make progress for project 2. 

##Conclusion
In conclusion, it is clear that our inexperience with parsing massive and diverse data sets has stopped us from being able to conclude what is a very interesting and promising project. We learned a ton about the available software project analysis tools, and have a much better understanding of the challenge that is preparing data for use. Going forward we intend to investigate the feasibility of generating meaningful results considering our skill level, and resources in this project.

#Project Management
##Milestones:
1. Acquire data (66000+ emails).
2. Preprocess data into a format we can work with.
3. Build tool to generate a list of top emailers.
4. Build tool to generate a list of pairs of the people who replied to eachother the most.
5. Run the tools on the data, and run Gource on the codebase.
6. Analyze our results in combination with GitHub statistics, and any internal documentation we can find.
7. Summarize findings.

##Roles of Team Members:
Brandon Leech and Jorin Weatherston shared the workload evenly and took part in the same tasks.

##References
* http://mail-archives.apache.org/mod_mbox/ant-dev/
* https://github.com/apache/ant/graphs/contributors?from=2001-12-18&to=2002-02-01&type=c
* http://ant.apache.org/contributors.html
