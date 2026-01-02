const gardenBtn = document.querySelector("#displaygardens");
const createGardenBtn = document.querySelector("#postgarden")
gardenBtn.addEventListener("click", displayInfo);
createGardenBtn.addEventListener("click", createGarden);
const output = document.querySelector("ul");

async function createGarden(){
    try{
        const response = await fetch('http://localhost:8080/api/gardens', {
            method:'POST',
            headers:{
                "Content-Type": "application/json",
            },
            body: JSON.stringify({gardenName:String(Math.random())})
        });
        if(!response.ok){
            throw new Error(`Response status: ${response.status}`);
        }
        console.log(response);

    }
    catch(error){
        console.error(error.message);
    }
}


async function displayInfo(){
    try{
        const response = await fetch('http://localhost:8080/api/gardens');
        if(!response.ok){
            throw new Error(`Response status: ${response.status}`);
        }
        const gardens = await response.json();
        console.log(gardens);

        output.innerHTML='';

        for(const garden of gardens){
            const gardenId = document.createElement("li");
            gardenId.textContent=garden['gardenId']
            output.appendChild(gardenId);

            const gardenInfo = document.createElement("ul");
            output.appendChild(gardenInfo);
            const gardenName = document.createElement("li");
            gardenName.textContent=garden['gardenName'];
            gardenInfo.appendChild(gardenName);

            for(const gardenZone of garden['gardenZones']){
                const gardenZoneId = document.createElement("li");
                gardenZoneId.textContent=gardenZone['gardenZoneId'];
                gardenInfo.appendChild(gardenZoneId);

                const gardenZoneName = document.createElement("li");
                gardenZoneName.textContent=gardenZone['gardenZoneName'];
                gardenInfo.appendChild(gardenZoneName);

            }
        
        }

    

    }
    catch(error){
        console.error(error.message);
    }
}




