# SolarSystemQuiz

I made this app initialy during EU Android scholarship, current app version is a bit modified version. I tried to make this app to be maximum universal and simple if someone like just to add new questions to it, so to do that it is needed to only edit one VariableContainer - class, there is no need to add new activities, whole layout is build by code. 

To achive that I build Quiz class which is container for 3 different question fragments and score fragment, every fragment is displayed in order cycle: 

first -one correct answer type fragment,

second -three correct answer type fragment,

third- write down answer type fragment,

after that, if there are more questions it again loading new cycle of fragments ( due to that cycle order, questions and answers must be added in this certain order in VariableContainer class). 

If questions ends class Quiz will load score fragment wich displays player final score.

I understand that code could be a bit hard to read, because of a lot dependecies betwenn classes and fragments, but it was nesessary to archive program based on fragments without multiplyaing layout activities with every each question. 

I think this program could be easly updated to take questions and answers from database, by modifying VariableContainer class, also it could be added an method to randomize questions order.
