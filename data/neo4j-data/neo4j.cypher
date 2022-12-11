CREATE (SmithR:User{name:'Smith Reed', email: 'smithreed@gmail.com', password: '12345'})
CREATE (PetriS:User{name:'Petri Santo', email: 'santo123@hotmail.com', password: 'petri_santo123'})

CREATE (User:Role{name:'User'})
CREATE (Admin:Role{name:'Admin'})

CREATE
(SmithR)-[:ASSIGNED]->(User),
(PetriS)-[:ASSIGNED]->(User)

CREATE (NewYorkWeekendTour:Trip{title: 'New York, all inclusive for the family', description: 'tbd', price: 4000.0, duration: '2 days', availability: 'Week 28-33', rating: 0.0})

CREATE (NewYork:Location{name:'New York City'})
CREATE (US:Country{name: 'United States Of America'})

CREATE (NewYork)-[:LOCATED_IN]->(US)

CREATE (NewYorkWeekendTour)-[:OCCUR_AT]->(NewYork)

CREATE (NewYorkREVIEW1: Review{title: 'Best city trip ever', rating: 5, text: 'The tour guides throughout the whole trip has been great, and the greatest food I ever had. Would recommend everytime', visit: '2021-07-12'})
CREATE (NewYorkREVIEW2: Review{title: 'Worst trip ever', rating: 1, text: 'Nothing was like it was avertised', visit: '2020-02-02'})

CREATE
(SmithR)-[:WROTE]->(NewYorkREVIEW1),
(PetriS)-[:WROTE]->(NewYorkREVIEW2)

CREATE
(NewYorkREVIEW1)-[:REVIEWED]->(NewYorkWeekendTour),
(NewYorkREVIEW2)-[:REVIEWED]->(NewYorkWeekendTour)

CREATE (Food: Tag{name: 'Food & Drink'})
CREATE (City: Tag{name: 'City'})
CREATE (Culture: Tag{name: 'Art & Culture'})

CREATE
(Food)-[:TAGGED]->(NewYorkWeekendTour),
(City)-[:TAGGED]->(NewYorkWeekendTour),
(Culture)-[:TAGGED]->(NewYorkWeekendTour)



