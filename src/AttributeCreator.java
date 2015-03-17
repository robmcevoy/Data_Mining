import java.util.ArrayList;


public class AttributeCreator{
	private final String ACCIDENT_SEVERITY = "Accident Severity";
	private final int ACCIDENT_SEVERITY_INDEX = 6;
	private final int[] AC_POSSIBLE_VALUES = {1, 2, 3};
	private final String LIGHTING_CONDITIONS = "Lighting Conditions";
	private final int LIGHTING_CONDITIONS_INDEX = 24;
	private final int[] LC_POSSIBLE_VALUES = {1, 4, 5, 6, 7};
	private final String URBAN_RURAL = "Urban Rural";
	private final int URBAN_RURAL_INDEX = 29;
	private final int[] UR_POSSIBLE_VALUES = {1, 2, 3};
	private final String DAY_OF_WEEK = "Day of Week";
	private final int DAY_OF_WEEK_INDEX = 10;
	private final int[] DOW_POSSIBLE_VALUES={1,2,3,4,5,6,7};
	private final String ROAD_TYPE = "Road Type";
	private final int ROAD_TYPE_INDEX = 16;
	private final int[] RT_POSSIBLE_VALUES = {1,2,3,6,7,9};
	private final String SPEED_LIMIT = "Speed Limit";
	private final int SPEED_LIMIT_INDEX = 17;
	private final int[] SL_POSSIBLE_VALUES = {10,20,50,30,40,60,70};
	private final String JUNCTION_DETAIL = "Junction Detail";
	private final int JUNCTION_DETAIL_INDEX = 18;
	private final int[] JD_POSSIBLE_VALUES = {-1,0,1,2,3,4,5,6,7,8,9};
	private final String WEATHER_CONDITION = "Weather Condition";
	private final int WEATHER_CONDITIONS_INDEX = 25;
	private final int[] WC_POSSIBLE_VALUES = {1,2,3,4,5,6,7,8,9};
	private final String FIRST_ROAD_CLASS = "First Road Class";
	private final int FIRST_ROAD_CLASS_INDEX = 14;
	private final int[] FRC_POSSIBLE_VALUES = {1,2,3,4,5,6};
	private final String SECOND_ROAD_CLASS = "Second Road Class";
	private final int SECOND_ROAD_CLASS_INDEX = 20;
	private final int[] SRC_POSSIBLE_VALUES = {-1,1,2,3,4,5,6};
	private final String JUNCTION_CONTROL = "Junction Control";
	private final int JUNCTION_CONTROL_INDEX = 19;
	private final int[] JC_POSSIBLE_VALUES = {-1,0,1,2,3,4};
	private final String PEDESTRIAN_CROSSING_HUMAN_CONTROL = "Pedestrian Crossing Human Control";
	private final int PEDESTRIAN_CROSSING_HUMAN_CONTROL_INDEX = 22;
	private final int[] PCHC_POSSIBLE_VALUES = {-1,0,1,2};
	private final String PEDESTRIAN_CROSSING_PHYSICAL_FACILITIES = "Pedestrian Crossing Physical Facilites";
	private final int PEDESTRIAN_CROSSING_PHYSICAL_FACILITIES_INDEX = 23;
	private final int[] PCPF_POSSIBLE_VALUES = {-1,0,1,4,5,7,8};
	private final String ROAD_SURFACE_CONDITIONS = "Road Surface Conditions";
	private final int ROAD_SURFACE_CONDITIONS_INDEX = 26;
	private final int[] RFC_POSSIBLE_VALUES= {-1,1,2,3,4,5};
	private final String SPECIAL_CONDITIONS_ON_SITE = "Special Conditions on Site";
	private final int SPECIAL_CONDITIONS_ON_SITE_INDEX = 27;
	private final int[] SCOS_POSSIBLE_VALUES = {-1,0,1,2,3,4,5,6,7};
	private final String CARRIAGEWAY_HAZARDS = "Carriageway Hazards";
	private final int CARIIAGEWAY_HAZARDS_INDEX = 28;
	private final int[] CH_POSSIBLE_VALUES = {-1,0,1,2,3,6,7};
	private final String DID_POLICE_OFFICE_ATTEND = "Did Police Officer Attend";
	private final int DID_POLICE_OFFICE_ATTEND_INDEX = 30; 
	private final int[] DPOA_POSSIBLE_VALUES = {-1,1,2,3};
	private final String LOCATION = "Location";
	private final int LOCATION_INDEX = 3;
	private final String TIME = "Time";
	private final int TIME_INDEX = 11;
	private final String DATE = "Date";
	private final int DATE_INDEX = 9;
	private final String NUM_VEHICLES = "Number of Vehicles";
	private final int NUM_VEHICLES_INDEX = 7;
	private final String NUM_CASUALTIES = "Number of Casualties";
	private final int NUM_CASUALTIES_INDEX = 8;
	//TODO police force ?
	//TODO local authority?
	//TODO road number 1 & 2?
	private ArrayList<Attribute> nonClassAttributes;
	
	public AttributeCreator(){
		nonClassAttributes = new ArrayList<Attribute>();
		nonClassAttributes.add(new IntegerCategoricalAttribute(LIGHTING_CONDITIONS,LIGHTING_CONDITIONS_INDEX,LC_POSSIBLE_VALUES));
		nonClassAttributes.add(new IntegerCategoricalAttribute(URBAN_RURAL,URBAN_RURAL_INDEX,UR_POSSIBLE_VALUES));
		nonClassAttributes.add(new IntegerCategoricalAttribute(DAY_OF_WEEK,DAY_OF_WEEK_INDEX, DOW_POSSIBLE_VALUES));
		nonClassAttributes.add(new IntegerCategoricalAttribute(ROAD_TYPE,ROAD_TYPE_INDEX,  RT_POSSIBLE_VALUES));
		nonClassAttributes.add(new IntegerCategoricalAttribute(SPEED_LIMIT,SPEED_LIMIT_INDEX, SL_POSSIBLE_VALUES));
		nonClassAttributes.add(new IntegerCategoricalAttribute(JUNCTION_DETAIL,JUNCTION_DETAIL_INDEX, JD_POSSIBLE_VALUES));
		nonClassAttributes.add(new IntegerCategoricalAttribute(WEATHER_CONDITION,WEATHER_CONDITIONS_INDEX, WC_POSSIBLE_VALUES));
		nonClassAttributes.add(new IntegerCategoricalAttribute(FIRST_ROAD_CLASS,FIRST_ROAD_CLASS_INDEX, FRC_POSSIBLE_VALUES));
		nonClassAttributes.add(new IntegerCategoricalAttribute(JUNCTION_CONTROL,JUNCTION_CONTROL_INDEX, JC_POSSIBLE_VALUES));
		nonClassAttributes.add(new IntegerCategoricalAttribute(SECOND_ROAD_CLASS,SECOND_ROAD_CLASS_INDEX, SRC_POSSIBLE_VALUES));
		nonClassAttributes.add(new IntegerCategoricalAttribute(PEDESTRIAN_CROSSING_HUMAN_CONTROL,PEDESTRIAN_CROSSING_HUMAN_CONTROL_INDEX, PCHC_POSSIBLE_VALUES));
		nonClassAttributes.add(new IntegerCategoricalAttribute(PEDESTRIAN_CROSSING_PHYSICAL_FACILITIES,PEDESTRIAN_CROSSING_PHYSICAL_FACILITIES_INDEX, PCPF_POSSIBLE_VALUES ));
		nonClassAttributes.add(new IntegerCategoricalAttribute(ROAD_SURFACE_CONDITIONS,ROAD_SURFACE_CONDITIONS_INDEX, RFC_POSSIBLE_VALUES));
		nonClassAttributes.add(new IntegerCategoricalAttribute(SPECIAL_CONDITIONS_ON_SITE,SPECIAL_CONDITIONS_ON_SITE_INDEX, SCOS_POSSIBLE_VALUES));
		nonClassAttributes.add(new IntegerCategoricalAttribute(CARRIAGEWAY_HAZARDS,CARIIAGEWAY_HAZARDS_INDEX, CH_POSSIBLE_VALUES));
		nonClassAttributes.add(new IntegerCategoricalAttribute(DID_POLICE_OFFICE_ATTEND, DID_POLICE_OFFICE_ATTEND_INDEX, DPOA_POSSIBLE_VALUES));
		/*********** Continuous Attributes **************/
		nonClassAttributes.add(new TimeAttribute(TIME, TIME_INDEX));
		nonClassAttributes.add(new NumberOfAttribute(NUM_VEHICLES, NUM_VEHICLES_INDEX));
		nonClassAttributes.add(new NumberOfAttribute(NUM_CASUALTIES, NUM_CASUALTIES_INDEX));
		nonClassAttributes.add(new LocationAttribute(LOCATION, LOCATION_INDEX));
		//nonClassAttributes.add(new DateAttribute(DATE, DATE_INDEX));
	}
	
	public ArrayList<Attribute> getNonClassAttributes(){
		return nonClassAttributes;
	}
	
	public Attribute getClassAttribute(){
		return new IntegerCategoricalAttribute(ACCIDENT_SEVERITY,ACCIDENT_SEVERITY_INDEX,AC_POSSIBLE_VALUES);
	}
	
	public Attribute getTimeAttribute(){
		return new TimeAttribute(TIME, TIME_INDEX);
	}
}
