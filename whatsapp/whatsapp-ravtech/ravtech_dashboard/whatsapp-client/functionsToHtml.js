


let currentUser = localStorage.getItem("name")
let content = document.getElementById("content")
let users =[];
let messages =[];
let nameUser ="";


function getUsers(val){
   val = JSON.parse(val);
   console.log(typeof val); 
}





function getAllMessagesOfSender(val){
    messages =[]
    const valParse = JSON.parse(val)
    for (i in valParse){
        nameUser =  valParse[i].receiverId == localStorage.getItem("name")?valParse[i].senderId:valParse[i].receiverId;
       console.log(name);
        if (users.includes(nameUser))continue;
        users.push(nameUser)
        valParse[i].dateTime = parseDate(valParse[i].dateTime) 
        messages.push(valParse[i]) 
             
    }
    console.log(messages[0].dateTime);
    
    writeToHtmlUsers();
}




function getAllMessagesByUser(val){
    console.log(val);
    
    messages =[]
    const valParse = JSON.parse(val)
    for (i in valParse){
        valParse[i].dateTime = parseDate(valParse[i].dateTime) 
        messages.push(valParse[i])       
    }    
    writeToHtmlMessages();
}








function writeToHtmlUsers(){
    content.innerHTML ="";
    for(let i=0;i<users.length;i++){
        content.innerHTML += `<div class="wrapMessage">
        <div id="${nameUser}" class="${nameUser}" onclick="getAllMessagesByUser(this.id)" >
        <div class="msgName">
            <span id="spanName">${users[i]}</span>
            <span id="spanHour">${messages[i].dateTime}</span>
        </div>
        <div class="msgText">
            <span id="msgText">${messages[i].text}</span>
            </div>
        </div>
        </div><hr>`
    }
}




function writeToHtmlMessages(){
    content.innerHTML ="";
    for(let i=0;i<messages.length;i++){
        content.innerHTML += `<div class="wrapMessage">
        <div id="${messages[i].id}" class="${messages[i].id}" >
        <div class="msgText">
            <span id="spanText">${messages[i].text}</span>
            <span id="spanHour">${messages[i].dateTime}</span>
        </div>
        </div>
        </div><hr>`
    }
}





function parseDate(date){
    let dateArr= date.split("")
    return dateArr[3]
}



 function getAllMessagesByUser(userId){
    console.log(getAllMessagesByUser);
    
    getAllMessagesByUserService("plpl","plplpl")
    
    console.log(userId);
    
}