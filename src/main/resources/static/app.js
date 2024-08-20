const stompClient = new StompJs.Client({
    brokerURL: 'ws://localhost:8080/chat'
});

stompClient.onConnect = (frame) => {
    setConnected(true);
    console.log('Connected: ' + frame);

    const roomId = $("#roomId").val();
    stompClient.subscribe(`/sub/chat/rooms/${roomId}`, (message) => {
        showMessage(JSON.parse(message.body));
    });
};

stompClient.onWebSocketError = (error) => {
    console.error('Error with websocket', error);
};

stompClient.onStompError = (frame) => {
    console.error('Broker reported error: ' + frame.headers['message']);
    console.error('Additional details: ' + frame.body);
};

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    stompClient.activate();
}

function disconnect() {
    stompClient.deactivate();
    setConnected(false);
    console.log("Disconnected");
}

function sendMessage() {
    const roomId = $("#roomId").val();
    const username = $("#username").val();
    const message = $("#message").val();

    const chatMessageRequest = {
        username: username,
        message: message
    }

    stompClient.publish({
        destination: `/pub/chat/rooms/${roomId}`,
        body: JSON.stringify(chatMessageRequest),
        headers: {
            "Content-Type": "application/json"
        }
    });
}

function showMessage(chatMessage) {
    const username = chatMessage.username;
    const message = chatMessage.message;
    
    const row = `<tr><td>${username}: ${message}</td></tr>`;
    $("#greetings").append(row);
}

$(function () {
    $("form").on('submit', (e) => e.preventDefault());
    $( "#connect" ).click(() => connect());
    $( "#disconnect" ).click(() => disconnect());
    $( "#send" ).click(() => sendMessage());
});