         // Configuración de Salesforce
// Para configurar Salesforce y obtener las credenciales de API, necesitarás seguir los siguientes pasos:

// Iniciar sesión en Salesforce y dirigirte a la página "Setup".
// En la barra de búsqueda, busca "App Manager" y selecciona la opción.
// Haz clic en el botón "New Connected App".
// Completa los campos requeridos, como el nombre y la descripción de tu aplicación.
// En la sección "API (Enable OAuth Settings)", marca la casilla "Enable OAuth Settings".
// En la sección "Callback URL", ingresa la URL de tu servidor donde se configurará un endpoint para recibir los eventos de Salesforce.
// En la sección "Selected OAuth Scopes", selecciona los permisos necesarios para acceder a los datos y eventos en Salesforce.
// Haz clic en el botón "Save" para guardar la configuración de tu Connected App.
// Una vez guardada la configuración, obtendrás las credenciales de API, incluyendo el Client ID y el Client Secret. Estas credenciales serán necesarias para autenticar con Salesforce desde tu servidor.
// Escribir Apex Triggers
// Para escribir Apex Triggers en Salesforce que llamen a un endpoint en tu servidor cuando ocurran eventos, necesitarás seguir estos pasos:

// En Salesforce, dirígete a la página "Setup".
// En la barra de búsqueda, busca "Apex Triggers" y selecciona la opción.
// Haz clic en el botón "New Trigger" para crear un nuevo trigger.
// Completa los campos requeridos, como el nombre y el objeto al que se asociará el trigger.
// En el código del trigger, puedes usar el siguiente ejemplo como base:

         // Escribir Apex Triggers
// Para escribir Apex Triggers en Salesforce que llamen a un endpoint en tu servidor cuando ocurran eventos, necesitarás seguir estos pasos:

// En Salesforce, dirígete a la página "Setup".
// En la barra de búsqueda, busca "Apex Triggers" y selecciona la opción.
// Haz clic en el botón "New Trigger" para crear un nuevo trigger.
// Completa los campos requeridos, como el nombre y el objeto al que se asociará el trigger.
// En el código del trigger, puedes usar el siguiente ejemplo como base:

trigger MyTrigger on ObjectName (trigger_events) {
    // Lógica del trigger

    // Llamar al endpoint en tu servidor
    HttpRequest request = new HttpRequest();
    request.setEndpoint('https://tu-servidor.com/endpoint');
    request.setMethod('POST');
    request.setHeader('Content-Type', 'application/json');
    request.setBody('{"data": "información del evento"}');

    HttpResponse response = new Http().send(request);
}

// En el código anterior, reemplaza 'ObjectName' con