// Setup
var collection = {
    "2548": {
      "album": "Sonic Highways",
      "artist": "Foo Fighters",
      "tracks": [ 
        "Something From Nothing", 
        "The Feast and the Famine" 
      ]
    },
    "2468": {
      "album": "Royal Blood",
      "artist": "Royal Blood",
      "tracks": [ 
		"Out of the Black",
        "Ten Tonne Skeleton", 
        "Blood Hands" 
      ]
    },
    "1245": {
      "artist": "Carpenter Brut",
      "tracks": [ ]
    },
    "5439": {
      "album": "Muse Black Holes Revelations" //That doesn't look right
    }
};
// Keep a copy of the collection for tests
var collectionCopy = JSON.parse(JSON.stringify(collection));

// Only change code below this line
function updateRecords(id, prop, value) {
  if(prop === "tracks" && value !== ""){
    if(collection[id][prop]) { //Check that this record has a "tracks" property
      collection[id][prop].push(value);
    } else {
      collection[id][prop] = [value]; //Create a new "tracks" property for this record
    }
  } else if (value!== ""){
    collection[id][prop] = value;
  } else { //Value is empty, so we must delete this particular property of this record
    delete collection[id][prop];
  }
  return collection;
}

// Alter values below to test your code
updateRecords(5439, "artist", "Muse");
updateRecords(5439, "album", "Black Holes and Revelations");
