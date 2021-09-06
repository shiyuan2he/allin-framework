<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>web socket im</title>
        <!-- <script type="text/javascript" src="js/websocket.js"></script> -->
    </head>
    <body>
        <h2>Hello World!</h2>
    </body>
    <script>
        // Create WebSocket connection.
        const socket = new WebSocket('ws://localhost:8080/3/test');

        // Connection opened
        socket.addEventListener('open', function (event) {
        socket.send('Hello Server!');
        });

        // Listen for messages
        socket.addEventListener('message', function (event) {
        console.log('Message from server ', event.data);
        });

        socket.addEventListener('error', function (event) {
        console.log('error ', event.data);
        });

    </script>
</html>