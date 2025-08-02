
//	連線到 MyClient.html、myjs.js
//	myjs.js：WebSocket 連線與訊息處理邏輯


window.onload = function(){
	let start = document.getElementById("start");
	let chatDiv = document.getElementById("chatDiv");
	let mesg = document.getElementById("mesg");
	let send = document.getElementById("send");
	let log = document.getElementById("log");
	
	start.style.display = "block";
	chatDiv.style.display = "none";
	
	let webSocket;
	
	// 建立連線
	start.addEventListener("click",function(){
		connect("ws://localhost:8080/labWeb/myserver");
		console.log("myjs.js loaded");

	});
	send.addEventListener("click", function(){
		let message = {
			message: mesg.value
		};
		// 接收到訊息後轉成字串，透過webSocket.send送給伺服器
		webSocket.send(JSON.stringify(message));
	});
	
	function connect(url){
		// 建立一個新的 WebSocket 物件並賦值給 webSocket
		webSocket = new WebSocket(url);
		
		webSocket.onopen = function(){
			console.log("onopen");
			start.style.display = "none";
			chatDiv.style.display = "block";
		};
		
		// 當伺服器傳回訊息時觸發
		webSocket.onmessage = function(event){
			// 取得 event.data（伺服器傳來的字串），用 JSON.parse 解析成物件
			let mesgObj = JSON.parse(event.data);
			// 把訊息內容 mesgObj.message 加到 log 區塊中
			log.innerHTML += mesgObj.message + "<br />";
		};
		webSocket.onclose = function(){
			console.log("onclose");
		};
		// Error會觸發事件，所以要帶參數
		webSocket.onerror = function(event){
			console.log("onerror:" + event.data);
		};
	}
	
	
	
}
			
			
			

