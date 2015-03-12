import java.util.ArrayList;


public class AttributeCreator{
	private final String ACCIDENT_SEVERITY = "Accident Severity";
	private final int ACCIDENT_SEVERITY_INDEX = 6;
	private final int[] AC__POSSIBLE_VALUES = {1, 2, 3};
	private final String LIGHTING_CONDITIONS = "Lighting Conditions";
	private final int LIGHTING_CONDITIONS_INDEX = 24;
	private final int[] LC__POSSIBLE_VALUES = {1, 4, 5, 6, 7};
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
	private final int[] CH_POSSIBLR_VALUES = {-1,0,1,2,3,6,7};
	//TODO location
	//TODO time
	//TODO date
	//TODO police force ?
	//TODO did police officer attend
	//TODO number of vehicles?
	//TODO number of casualties?
	//TODO local authority?
	//TODO road number 1 & 2?
	private ArrayList<Attribute> nonClassAttributes;
	
	public AttributeCreator(){
		nonClassAttributes = new ArrayList<Attribute>();
		nonClassAttributes.add(new Attribute(LIGHTING_CONDITIONS,LIGHTING_CONDITIONS_INDEX,LC__POSSIBLE_VALUES));
		nonClassAttributes.add(new Attribute(URBAN_RURAL,URBAN_RURAL_INDEX,UR_POSSIBLE_VALUES));
		nonClassAttributes.add(new Attribute(DAY_OF_WEEK,DAY_OF_WEEK_INDEX, DOW_POSSIBLE_VALUES));
		nonClassAttributes.add(new Attribute(ROAD_TYPE,ROAD_TYPE_INDEX,  RT_POSSIBLE_VALUES));
		nonClassAttributes.add(new Attribute(SPEED_LIMIT,SPEED_LIMIT_INDEX, SL_POSSIBLE_VALUES));
		nonClassAttributes.add(new Attribute(JUNCTION_DETAIL,JUNCTION_DETAIL_INDEX, JD_POSSIBLE_VALUES));
		nonClassAttributes.add(new Attribute(WEATHER_CONDITION,WEATHER_CONDITIONS_INDEX, WC_POSSIBLE_VALUES));
		nonClassAttributes.add(new Attribute(FIRST_ROAD_CLASS,FIRST_ROAD_CLASS_INDEX, FRC_POSSIBLE_VALUES));
		nonClassAttributes.add(new Attribute(JUNCTION_CONTROL,JUNCTION_CONTROL_INDEX, JC_POSSIBLE_VALUES));
		nonClassAttributes.add(new Attribute(SECOND_ROAD_CLASS,SECOND_ROAD_CLASS_INDEX, SRC_POSSIBLE_VALUES));
		nonClassAttributes.add(new Attribute(PEDESTRIAN_CROSSING_HUMAN_CONTROL,PEDESTRIAN_CROSSING_HUMAN_CONTROL_INDEX, PCHC_POSSIBLE_VALUES));
		nonClassAttributes.add(new Attribute(PEDESTRIAN_CROSSING_PHYSICAL_FACILITIES,PEDESTRIAN_CROSSING_PHYSICAL_FACILITIES_INDEX, PCPF_POSSIBLE_VALUES ));
		nonClassAttributes.add(new Attribute(ROAD_SURFACE_CONDITIONS,ROAD_SURFACE_CONDITIONS_INDEX, RFC_POSSIBLE_VALUES));
		nonClassAttributes.add(new Attribute(SPECIAL_CONDITIONS_ON_SITE,SPECIAL_CONDITIONS_ON_SITE_INDEX, SCOS_POSSIBLE_VALUES));
		nonClassAttributes.add(new Attribute(CARRIAGEWAY_HAZARDS,CARIIAGEWAY_HAZARDS_INDEX, CH_POSSIBLR_VALUES));
	}
	
	public ArrayList<Attribute> getNonClassAttributes(){
		return nonClassAttributes;
	}
	
	public Attribute getClassAttribute(){
		return new Attribute(ACCIDENT_SEVERITY,ACCIDENT_SEVERITY_INDEX,AC__POSSIBLE_VALUES);
	}
}
