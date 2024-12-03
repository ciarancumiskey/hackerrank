#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the roadsAndLibraries function below.
"""
Given a list of cities from 1 through n, a cost of building a library, a cost of 
repairing a road and a matrix of pairs representing routes between cities, calculate the
minimum cost of providing every citizen with access to a library.
    n is the number of cities
    c_lib is the cost of building a library
    c_road is the cost of repairing a road
    cities is a 2D list of integers [a, b] where a is the starting city of a bidirectional route, and b is the destination
"""
def roadsAndLibraries(n, c_lib, c_road, cities):
    if c_lib <= c_road:
        # There's no point repairing the roads, just build a library in each city
        return n*c_lib
    else:
        routes = {} # Create an adjacency matrix of all possible roads
        # Create a prefilled list for all cities representing whether they've been visited yet
        visited = [False] * n 
        libraries_needed = 0
        # Create an adjacency matrix listing all cities that can be linked by roads
        city_path = {} 

        """
        Perform a depth-first search to find all of the cities reachable from the starting city 
            city is the start of the path
            path_nodes counts how many cities have been visited from the starting city 
        """
        def dfs(city, path_nodes):
            if not visited[city]:
                city_path[path_nodes] = (city_path.get(path_nodes, 0) + 1)
            visited[city] = True
            # Create a list for cities that could reach this city by road
            city_neighbours = []
            try:
                city_neighbours = routes[city + 1]
            except KeyError as ke:
                # This city is isolated from any others, it'll need its own library
                pass
            for city_id in city_neighbours:
                if not visited[city_id - 1]:
                    print("Performing recursive DFS on " + str(city_id-1))
                    dfs(city_id-1, path_nodes) # Recursion time!

        # Populate the adjacency matrix with repaired roads
        for road in cities:
            routes[road[0]] = (routes.get(road[0], []) + [road[1]])
            routes[road[1]] = (routes.get(road[1], []) + [road[0]])
            
        # Iterate through all of the cities    
        for city_itr in range(n):
            if not visited[city_itr]:
                dfs(city_itr, city_itr)
                libraries_needed += 1
        roads_needed = sum(x-1 for x in city_path.values())
        return roads_needed*c_road + libraries_needed*c_lib
    

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    map_count = int(input()) # number of maps the user wants to enter

    for map_itr in range(map_count):
        nmC_libC_road = input().split()

        city_count = int(nmC_libC_road[0]) # number of cities in the map

        road_count = int(nmC_libC_road[1]) # number of roads in the map

        c_lib = int(nmC_libC_road[2]) # cost to rebuild a library

        c_road = int(nmC_libC_road[3]) # cost to repair a road

        cities = [] 

        for _ in range(road_count): # fill the list of roads
            cities.append(list(map(int, input().rstrip().split())))

        result = roadsAndLibraries(city_count, c_lib, c_road, cities)

        fptr.write(str(result) + '\n')

    fptr.close()

