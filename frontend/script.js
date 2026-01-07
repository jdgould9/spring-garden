//--CLASS DECLARATIONS--
class Garden{
    constructor(gardenId, gardenName){
        this.gardenId=gardenId;
        this.gardenName=gardenName;
        this.gardenZones=[]
    }
}

class GardenZone{
    constructor(gardenZoneId, gardenZoneName){
        this.gardenZoneId = gardenZoneId;
        this.gardenZoneName=gardenZoneName;
        this.plants=[]
    }
}

class Plant{
    constructor(plantId, plantName){
        this.plantId=plantId;
        this.plantName=plantName;
    }
}

class TrackerPolicy{
    constructor(trackerPolicyId, trackerPolicyName, trackerPolicyDescription,
        trackerPolicyTargetType, trackerPolicyInterval){
            this.trackerPolicyId=trackerPolicyId;
            this.trackerPolicyName=trackerPolicyName;
            this.trackerPolicyDescription=trackerPolicyDescription;
            this.trackerPolicyTargetType=trackerPolicyTargetType;
            this.trackerPolicyInterval=trackerPolicyInterval;
            this.trackerPolicyAssignments=[];
        }
}

//--GLOBAL VARIABLES--
let gardens=[];
let trackerPolicies=[];

//--INITIALIZATION--    
//Fetches all gardens and tracker policies
async function fetchInitialInfo(){
    try{
        const gardenResponse = await fetch("http://localhost:8080/api/gardens");
        if(!gardenResponse.ok){
            throw new Error("Could not fetch gardens info");
        }
        const trackerPolicyResponse = await fetch("http://localhost:8080/api/trackers");
        if(!trackerPolicyResponse.ok){
            throw new Error("Could not fetch tracker policy info");
        }

        const gardenJson=await gardenResponse.json();
        const trackerPoliciesJson= await trackerPolicyResponse.json();

        console.log("JSONS...");
        
        console.log(gardenJson);
        console.log(trackerPoliciesJson);
        
        return [gardenJson, trackerPoliciesJson];
    }
    catch(error){
        console.error(error.message);
    }
}

//Populates gardens and tracker policies
function populateInitialInfo(gardensJson, trackerPoliciesJson){
    //Garden + zone info
    for(const gardenJson of gardensJson){
        const newGarden = gardenJsonToObject(gardenJson);
        for(const gardenZone of gardenJson["gardenZones"]){
            const newGardenZone=gardenZoneJsonToObject(gardenZone);
            newGarden.gardenZones.push(newGardenZone);
        }
        gardens.push(newGarden);
    }

    //Policy info
    for(const trackerPolicyJson of trackerPoliciesJson){
        const newTrackerPolicy = trackerPolicyJsonToObject(trackerPolicyJson);
        trackerPolicies.push(newTrackerPolicy);
    }
}

//Populates nav bar from garden and tracker policy global variables
function populateNavBar(){
    const gardensNavList = document.querySelector("#gardensNavList");

    for (const garden of gardens) {
        const gardenLi = document.createElement("li");
        gardenLi.textContent = garden.gardenName;

        const zonesUl = document.createElement("ul");

        for (const gardenZone of garden.gardenZones) {
            const zoneLi = document.createElement("li");
            zoneLi.textContent = gardenZone.gardenZoneName;
            zonesUl.appendChild(zoneLi);
        }

        gardenLi.appendChild(zonesUl);   // nest zones under garden
        gardensNavList.appendChild(gardenLi);
    }

    const trackersNavList=document.querySelector("#trackersNavList");

    //garden
    const gardenTrackers = trackerPolicies.filter((tracker)=>tracker.trackerPolicyTargetType=="GARDEN");
    const gardenTrackerTitleLi = document.createElement("li");
    gardenTrackerTitleLi.textContent="Garden";
    trackersNavList.appendChild(gardenTrackerTitleLi);

    const gardenTrackerUl = document.createElement("ul");
    trackersNavList.appendChild(gardenTrackerUl);
    for(const gardenTracker of gardenTrackers){
        const gardenTrackerLi = document.createElement("li");
        gardenTrackerLi.textContent=gardenTracker.trackerPolicyName;
        gardenTrackerUl.appendChild(gardenTrackerLi);
    }

    //zone
    const gardenZoneTrackers = trackerPolicies.filter((tracker)=>tracker.trackerPolicyTargetType=="GARDENZONE");
    const gardenZoneTrackerTitleLi = document.createElement("li");
    gardenZoneTrackerTitleLi.textContent="Garden zone";
    trackersNavList.appendChild(gardenZoneTrackerTitleLi);

    const gardenZoneTrackerUl = document.createElement("ul");
    trackersNavList.appendChild(gardenZoneTrackerUl);
    for(const gardenZoneTracker of gardenZoneTrackers){
        const gardenZoneTrackerLi = document.createElement("li");
        gardenZoneTrackerLi.textContent=gardenZoneTracker.trackerPolicyName;
        gardenZoneTrackerUl.appendChild(gardenZoneTrackerLi);
    }

    //plant
    const plantTrackers = trackerPolicies.filter((tracker)=>tracker.trackerPolicyTargetType=="PLANT");
    const plantTrackerTitleLi = document.createElement("li");
    plantTrackerTitleLi.textContent="Plant";
    trackersNavList.appendChild(plantTrackerTitleLi);

    const plantTrackerUl = document.createElement("ul");
    trackersNavList.appendChild(plantTrackerUl);
    for(const plantTracker of plantTrackers){
        const plantTrackerLi = document.createElement("li");
        plantTrackerLi.textContent=plantTracker.trackerPolicyName;
        plantTrackerUl.appendChild(plantTrackerLi);
    }
}

async function init(){
    const[gardensJson, trackerPoliciesJson] = await fetchInitialInfo();
    populateInitialInfo(gardensJson, trackerPoliciesJson);
    console.log("OBJECTS...");
    console.log("Gardens:", gardens);
    console.log("Tracker Policies:", trackerPolicies);


    populateNavBar(gardens, trackerPolicies);


}

init();



//--MAPPERS--
function gardenJsonToObject(gardenJson){
    return new Garden(
        gardenJson["gardenId"],
        gardenJson["gardenName"]
    );
}

function gardenZoneJsonToObject(gardenZoneJson){
    return new GardenZone(
        gardenZoneJson["gardenZoneId"],
        gardenZoneJson["gardenZoneName"]
    );
}

function plantJsonToObject(plantJson){
    return new Plant(
        plantJson["plantId"],
        plantJson["plantName"]
    );

}

function trackerPolicyJsonToObject(trackerPolicyJson){
    return new TrackerPolicy(
        trackerPolicyJson["trackerPolicyId"],
        trackerPolicyJson["name"],
        trackerPolicyJson["description"],
        trackerPolicyJson["targetType"],
        trackerPolicyJson["intervalHours"]
    );
}

















//Nav
    //Garden
        //Click: Garden name
        //Click: Zone name
    //Tracking
        //Click: Tracker policy
    
    //Create
        //Click: create garden
        //Click: create tracker


//Main
    //GARDEN, GARDENZONE
        //Subentity list
            //Foreach subentity:
                //Click: view subentity
                //Click: delete subentity

        //Assigned tracker list
            //Foreach policy:
                //Click: view policy
                //Click: detach policy
                //Click: record event

        //Click: attach policy

    //PLANT
        //Assigned tracker list
            //Foreach policy:
                //Click: view policy
                //Click: detach policy
                //Click: record event

        //Click: attach policy
        



    //POLICY ENTITY
        //Assignment list
            //Foreach assignment:
                //Click: view assignment entity
                //Click: detach assignment

        //Click: attach assignment



//Aside
    //ENTITY, POLICY
        //Click: edit entity/policy details
        //Click: delete entity/policy


