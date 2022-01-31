# Intro to JSON
JSON, or JavaScript Object Notation, is a lightweight text-based open standard designed for human-readable data interchange. This means it is a standardized method for machines to communicate using a language that isn't gibbersh to humans. JSON is not just for JavaScript, but is now widely used in projects of many languages including C, C++, Python, Java, and more. JSON is frequently used to deliver data to/from APIs.  

## JSON Objects

JSON objects are represented as a string of characters enclosed in curly braces, and organizes data in key/value pairs. The pairs are separated by commas, the keys and values are separated by colons. Keys are strings that identify the values, the values can be of several JSON compatible data types:
 - string - a series of characters enclosed in "double quotes".
 - number - positive or negatives integers or floats.
 - object - one or more key/value pairs enclosed in {curly braces} separated by commas. (in this way we nest JSON objects)
 - array - collection of values separated by commas.
 - boolean - true or false value. Represented as the string literals `true` and `false` with no quotes.
 - null - indicates the absence of data. Represented as the string literal `null` with no quotes.

## JSON Escapes
Use backslash as an escape character in JSON. There are several escapable sequences:
 - \\" - in order to represent a literal double quote in a string
 - \\\ - in order to represent a literal backslash
 - \\/ - in order to represent a literal foreward slash
 - \b - backspace
 - \f - form feed
 - \n - new line
 - \r - carriage return
 - \t - tab


## Example ([From the Open Movie Database API](https://www.omdbapi.com/)):
```
{
	"Title": "The Grand Budapest Hotel",
	"Year": "2014",
	"Rated": "R",
	"Released": "28 Mar 2014",
	"Runtime": "99 min",
	"Genre": "Adventure, Comedy, Crime",
	"Director": "Wes Anderson",
	"Writer": "Stefan Zweig, Wes Anderson, Hugo Guinness",
	"Actors": "Ralph Fiennes, F. Murray Abraham, Mathieu Amalric",
	"Plot": "A writer encounters the owner of an aging high-class hotel, who tells him of his early years serving as a lobby boy in the hotel's glorious years under an exceptional concierge.",
	"Language": "English, French, German",
	"Country": "United States, Germany",
	"Awards": "Won 4 Oscars. 134 wins & 226 nominations total",
	"Poster": "https://m.media-amazon.com/images/M/MV5BMzM5NjUxOTEyMl5BMl5BanBnXkFtZTgwNjEyMDM0MDE@._V1_SX300.jpg",
	"Ratings": [{
		"Source": "Internet Movie Database",
		"Value": "8.1/10"
	}, {
		"Source": "Rotten Tomatoes",
		"Value": "92%"
	}, {
		"Source": "Metacritic",
		"Value": "88/100"
	}],
	"Metascore": "88",
	"imdbRating": "8.1",
	"imdbVotes": "741,394",
	"imdbID": "tt2278388",
	"Type": "movie",
	"DVD": "06 Dec 2015",
	"BoxOffice": "$59,301,324",
	"Production": "American Empirical Pictures",
	"Website": "N/A",
	"Response": "True"
}
```
Note:
 - The value associated with the Ratings key is an array of JSON objects.
 - The value associated with the Response key is "True". This is a string, not a boolean. It could have been represented as a bool, if it were lowercase and lacked double quotes.
 - This example is problematic due to the key naming, note that it doesn't follow any particular style. This can cause confusion when unmarshalling. 

<BR><BR>
## See Also:
 - [JSONLint - The JSON Validator](https://jsonlint.com/)
 - [JSON Vocabulary](https://json-schema.org/draft/2020-12/json-schema-validation.html)
