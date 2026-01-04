// const gardenBtn = document.querySelector("#displaygardens");
// const trackerBtn=document.querySelector("#displaytrackers")
// const createGardenBtn = document.querySelector("#postgarden")
// gardenBtn.addEventListener("click", displayGardenInfo);
// createGardenBtn.addEventListener("click", createRandomGarden);
// trackerBtn.addEventListener("click", displayTrackerInfo);
// const output = document.querySelector("ul");

// async function createRandomGarden(){
//     try{
//         const response = await fetch('http://localhost:8080/api/gardens', {
//             method:'POST',
//             headers:{
//                 "Content-Type": "application/json",
//             },
//             body: JSON.stringify({gardenName:String(Math.random())})
//         });
//         if(!response.ok){
//             throw new Error(`Response status: ${response.status}`);
//         }
//         console.log(response);

//     }
//     catch(error){
//         console.error(error.message);
//     }
// }


// async function displayGardenInfo(){
//     try{
//         const response = await fetch('http://localhost:8080/api/gardens');
//         if(!response.ok){
//             throw new Error(`Response status: ${response.status}`);
//         }
//         const gardens = await response.json();
//         console.log(gardens);

//         output.innerHTML='';

//         for(const garden of gardens){
//             const gardenId = document.createElement("li");
//             gardenId.textContent=garden['gardenId']
//             output.appendChild(gardenId);

//             const gardenInfo = document.createElement("ul");
//             output.appendChild(gardenInfo);
//             const gardenName = document.createElement("li");
//             gardenName.textContent=garden['gardenName'];
//             gardenInfo.appendChild(gardenName);

//             for(const gardenZone of garden['gardenZones']){
//                 const gardenZoneId = document.createElement("li");
//                 gardenZoneId.textContent=gardenZone['gardenZoneId'];
//                 gardenInfo.appendChild(gardenZoneId);

//                 const gardenZoneName = document.createElement("li");
//                 gardenZoneName.textContent=gardenZone['gardenZoneName'];
//                 gardenInfo.appendChild(gardenZoneName);

//             }
        
//         }
//     }
//     catch(error){
//         console.error(error.message);
//     }
// }

// async function displayTrackerInfo(){
//         try{
//         const response = await fetch('http://localhost:8080/api/trackers');
//         if(!response.ok){
//             throw new Error(`Response status: ${response.status}`);
//         }
//         const trackers = await response.json();
//         console.log(trackers);

//         output.innerHTML='';

//         for(const tracker of trackers){
//             const trackerPolicyIOd = document.createElement("li");
//             trackerPolicyIOd.textContent=tracker['trackerPolicyId']
//             output.appendChild(trackerPolicyIOd);

//             const trackerInfo = document.createElement("ul");
//             output.appendChild(trackerInfo);

//             const trackerName = document.createElement("li");
//             trackerName.textContent=tracker['name'];
//             trackerInfo.appendChild(trackerName);

//             const trackerIntervalHours = document.createElement("li");
//             trackerIntervalHours.textContent=tracker['intervalHours'];
//             trackerInfo.appendChild(trackerIntervalHours);

//             const trackerDescription = document.createElement("li");
//             trackerDescription.textContent=tracker['description'];
//             trackerInfo.appendChild(trackerDescription);

//             const trackerCreationDate = document.createElement("li");
//             trackerCreationDate.textContent=tracker['creationTime'];
//             trackerInfo.appendChild(trackerCreationDate);
//         }
//     }
//     catch(error){
//         console.error(error.message);
//     }
// }






