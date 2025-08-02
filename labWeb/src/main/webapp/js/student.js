window.onload = function(){
	let canvas, ctx;
	let webSocket = new WebSocket("ws://localhost:8080/labWeb/mycenter");
	let isConnect = false;
		
	webSocket.onopen = function(){
		console.log("onopen");
		isConnect = true;
	};
	webSocket.onmessage = function(e){
		console.log("onmessage:" + e.data);
		if (isConnect){
			let megObj = JSON.parse(e.data);
			if (megObj.isClear){
				clear();
			}else{
				if (megObj.isNewLine){
					newLine(megObj.x, megObj.y);
				}else{
					drawLine(megObj.x, megObj.y);
				}
			}
		}
	};
	webSocket.onclose = function(){isConnect = false;};
	webSocket.onerror = function(e){console.log("ERROR:" + e.data)};
	
	//-----------------------------
	canvas = document.getElementById("myDrawer");
	ctx = canvas.getContext("2d");
	
	function clear(){
		ctx.clearRect(0, 0, canvas.width, canvas.height);
	};
	function newLine(x, y){
		ctx.beginPath();
		ctx.lineWidth = 4;
		ctx.moveTo(x,y);		
	};
	function drawLine(x, y){
		ctx.lineTo(x, y);
		ctx.stroke();
	};	
}
