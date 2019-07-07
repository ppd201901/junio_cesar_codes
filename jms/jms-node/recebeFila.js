const stompit = require('stompit');
 
stompit.connect({ host: '192.168.0.100', port: 61613 }, (err, client) => {
 
  client.subscribe({ destination: 'fila.ppd' }, (err, msg) => {
 
    msg.readString('UTF-8', (err, body) => {
      console.log(body);
 
      //client.disconnect();
    });
 
  });
 
});