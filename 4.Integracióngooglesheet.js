// Executing: Integrar con Google Sheets: Configurar OAuth 2.0 para acceder a la API de Google Sheets. Escribir funciones que actualicen hojas de cálculo con los datos recibidos.

// Integrating with Google Sheets
// Para integrar con Google Sheets, necesitarás configurar la autenticación utilizando OAuth 2.0 y luego escribir funciones que puedan actualizar las hojas de cálculo con los datos recibidos.

// Configurando la Autenticación
// JavaScript/Node.js



const { google } = require('googleapis');

// Configura las credenciales de OAuth 2.0
const credentials = {
  client_id: 'TU_CLIENT_ID',
  client_secret: 'TU_CLIENT_SECRET',
  redirect_uris: ['TU_REDIRECT_URI'],
};

// Crea un cliente OAuth2
const oauth2Client = new google.auth.OAuth2(
  credentials.client_id,
  credentials.client_secret,
  credentials.redirect_uris[0]
);

// Genera el URL de autorización
const authUrl = oauth2Client.generateAuthUrl({
  access_type: 'offline',
  scope: ['https://www.googleapis.com/auth/spreadsheets'],
});

// Obtén el token de acceso
async function getAccessToken(code) {
  const { tokens } = await oauth2Client.getToken(code);
  return tokens.access_token;
}

// Configura el token de acceso para las futuras solicitudes
function setAccessToken(token) {
  oauth2Client.setCredentials({ access_token: token });
}

// Configura el token de actualización para obtener nuevos tokens de acceso si es necesario
function setRefreshToken(refreshToken) {
  oauth2Client.setCredentials({ refresh_token: refreshToken });
}

// Crea una instancia del cliente de Google Sheets
const sheets = google.sheets({ version: 'v4', auth: oauth2Client });
