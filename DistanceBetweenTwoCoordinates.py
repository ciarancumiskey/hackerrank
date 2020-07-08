from math import radians, cos, sin, asin
import sys

K_RADIUS = 6371 #km
M_RADIUS = 3956 #miles

"""
    Check if the user has entered the location in the format (latitude, longitude)
    :param locationToCheck: the set of coordinates to be checked
"""
def checkIfLocationIsProperlyFormatted(locationToCheck):
    if(len(locationToCheck) < 2):
        #User forgot to enter anything
        if locationToCheck == ['']:
            return 0, 0
        #User only entered the latitude:
        else:
            return locationToCheck[0], 0.0
    else:
        return locationToCheck

"""
    This function uses the haversine formula to calculate the distance between two sets of
    coordinates.
    :param location1: the first set of coordinates
    :param location2: the second set of coordinates
    :param unitsOfMeasurement: the units of measurement used in the calculation, defaults to kilometres
"""
def calculateDistance(location1, location2, unitsOfMeasurement = "km"):
    #Ensure the user has entered a valid input
    location1 = checkIfLocationIsProperlyFormatted(location1)
    location2 = checkIfLocationIsProperlyFormatted(location2)

    #Cast the inputs to floats
    lat1, lat2, lon1, lon2 = map(float, [location1[0], location2[0], location1[1], location2[1]])
    #Convert the coordinates to radian format for the haversine formula
    lat1, lat2, lon1, lon2 = map(radians, [lat1, lat2, lon1, lon2])
    diffLat = lat2 - lat1
    diffLon = lon2 - lon1
    arcsinInput = sin(diffLat / 2) ** 2 + cos(lat1) * cos(lat2) * sin(diffLon / 2) ** 2
    # Calculate the distance between the points in radians
    radiansResult = 2 * asin(arcsinInput ** 0.5)
    # Default to kilometres
    if (unitsOfMeasurement != "mi"):
        return str(K_RADIUS * radiansResult) + "km"
    else:
        return str(M_RADIUS * radiansResult) + "miles"

"""
    Enter the respective latitude and longitude of the two points and the units
    of measurement as command line arguments to skip the prompts.
"""
if __name__ == '__main__':
    #User hasn't entered the units of measurement they want to use
    if(len(sys.argv) < 6):
        unitsOfMeasurement = input("Please enter km to use kilometres or mi to use miles:")
        #User hasn't entered the second set of coordinates
        if(len(sys.argv) < 4):
            #User hasn't entered the first set of coordinates
            if(len(sys.argv) < 2):
                point1 = input("Please enter the first set of coordinates separated by a space:").split(" ")
            else:
                point1 = [sys.argv[1], sys.argv[2]]
            point2 = input("Please enter the second set of coordinates separated by a space:").split(" ")
        else:
            point1 = [sys.argv[1], sys.argv[2]]
            point2 = [sys.argv[3], sys.argv[4]]
    else:
        point1 = [sys.argv[1], sys.argv[2]]
        point2 = [sys.argv[3], sys.argv[4]]
        unitsOfMeasurement = sys.argv[5]
    print(calculateDistance(point1, point2, unitsOfMeasurement))

