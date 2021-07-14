
localStorage.setItem("name","aaa@gmail.com")

const urlUsers = "http://localhost:82/users/";
const urlMessages = "http://localhost:82/messages/"
getAllMessages(localStorage.getItem("name"))

function getAllUsers(){
    roterFunctions("GET",`${urlUsers}getAllUsers`,getUsers);
}


function getAllMessages(id){
    roterFunctions("GET",`${urlMessages}getAllMessageOfSender?senderId=${id}`,getAllMessagesOfSender);
}


export function getAllMessagesByUserService(senderId,userId){
    roterFunctions("GET",`${urlMessages}getAllMessageByUser?senderId=${senderId}&userId=${userId}`,getAllMessagesByUser);

}



