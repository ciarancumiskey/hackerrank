from math import radians, cos, sin, asin
import tkinter as tk

K_RADIUS = 6371 #km
M_RADIUS = 3956 #miles

"""
    This function uses the haversine formula to calculate the distance between two sets of
    coordinates.
    :param unitsOfMeasurement: the units of measurement used in the calculation, defaults to kilometres
"""
def calculate_distance(unitsOfMeasurement="km"):
  #Get the inputs from the Entry objects
  lat1, lat2, lon1, lon2 = ent_lat1.get(), ent_lon1.get(), ent_lat2.get(), ent_lon2.get()
  #Convert them to radians for the haversine formula
  lat1, lat2, lon1, lon2 = map(radians, map(float, [lat1, lat2, lon1, lon2]))
  diffLat = lat2 - lat1
  diffLon = lon2 - lon1
  arcsinInput = sin(diffLat / 2) ** 2 + cos(lat1) * cos(lat2) * sin(diffLon / 2) ** 2
  # Calculate the distance between the points in radians
  radiansResult = 2 * asin(arcsinInput ** 0.5)
  # Default to kilometres
  if unitsOfMeasurement != "mi":
    lbl_result["text"] = str(round(K_RADIUS * radiansResult, 3)) + "km"
  else:
    lbl_result["text"] = str(round(M_RADIUS * radiansResult, 3)) + " miles"

"""
  Handler method for the button which calculates the result in miles.
"""
def calculate_dist_miles():
  calculate_distance("mi")

window = tk.Tk()
window.title("Distance Calculator")

#Add the UI elements for the first set of coordinates
frm_coord = tk.Frame(master=window)
lbl_prompt1 = tk.Label(text="Please enter the first set of coordinates", master=frm_coord)
ent_lat1 = tk.Entry(width=20, master=frm_coord)
ent_lat1.insert(0, "0.0")
ent_lon1 = tk.Entry(width=20, master=frm_coord)
ent_lon1.insert(0, "0.0")

lbl_prompt1.grid(row=0, column=0, sticky="n")
ent_lat1.grid(row=1, column=0, sticky="e")
ent_lon1.grid(row=1, column=1, sticky="w")

#Add the UI elements for the second set of coordinates
lbl_prompt2 = tk.Label(text="Please enter the second set of coordinates", master=frm_coord)
ent_lat2 = tk.Entry(width=20, master=frm_coord)
ent_lat2.insert(0, "0.0")
ent_lon2 = tk.Entry(width=20, master=frm_coord)
ent_lon2.insert(0, "0.0")

lbl_prompt2.grid(row=2, column=0, sticky="n")
ent_lat2.grid(row=3, column=0, sticky="e")
ent_lon2.grid(row=3, column=1, sticky="w")

lbl_result = tk.Label(master=window, text="Result: ")
btn_calc_km = tk.Button(master=window, text="Calculate distance in km", command=calculate_distance)
btn_calc_mi = tk.Button(master=window, text="Calculate distance in miles", command=calculate_dist_miles)

frm_coord.grid(row=0, column=0, pady=3)
btn_calc_km.grid(row=1, column=0, )
btn_calc_mi.grid(row=2, column=0, )
lbl_result.grid(row=3)
window.mainloop()