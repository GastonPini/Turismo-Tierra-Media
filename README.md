# Turismo Tierra Media

turismo-tierra-media is a system that stores the information of different attractions of Middle Earth amusement park. The system suggests visits based on the location of the visitors, and also generates itineraries based on the information on preferences available in the user's profile.

Each attraction has its cost, its average time, the quota of daily visitors and the type of attraction (landscape, adventure, tasting).
For its part, for each user the system knows their budget, the time available for visits and the preferred type of attraction.


### Some implementation details:

#### The database contains tables for:
- Type of Attractions.
- Attractions.
- Promotions.
- Users.
- Itineraries.


Each promotion includes one or several attractions and benefits the user with a reduction in cost
total. The system is expected to allow the definition of promotions of three types:
- Percentage promotions (X% discount on the total cost).
- Absolute promotions ($ X for the entire package).
- Promotions A x B (if the user buys A,B,C then he gets D for free).


#### For each user, the system:

- Suggest an ​attraction that matches your preferences, costs and times​. The offer of packages is prioritized, the most expensive attractions and those that require more time, in that order. An attraction or package is not offered if a user cannot afford ir, or for which does not not have time available. An attraction that has already been included in a purchased package is also not offered.
Once the offers that coincide with the user's interests have been exhausted, those that do not coincide will be offered, under the same criteria.

- If the user accepts, it is saved within his daily suggestion. An accepted attraction or package cannot be cancelled.

- A summary of the user's entire itinerary is shown, counting the hours necessary to complete it and the coins the user must spend.