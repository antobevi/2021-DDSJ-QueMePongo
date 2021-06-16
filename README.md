# 2021-DDSJ-QueMePongo

~ *Primera Iteración* ~

Enunciado:

https://docs.google.com/document/d/1k1f-9AuIohlBGB2soSNePJ6jLxM37_tZeSD-hW_esIQ/edit

Requerimientos:

- Especificar qué tipo de prenda estoy cargando.
- Identificar a qué categoría pertenece una prenda.
- Poder indicar de qué tela o material está hecha una prenda.
- Poder indicar un color principal para mis prendas.
- Poder indicar, si existe, un color secundario para mis prendas.
- Evitar que haya prendas sin tipo, tela, categoría o color primario.
- Evitar que haya prendas cuya categoría no se condiga con su tipo.

Aclaraciones:

- Creo una clase TipoDePrenda que contenga como atributo a la Categoría (Enum) ya que de esa forma evito tener que validar la categoría con su tipo de prenda y se simplifica el constructor de Prenda.

~ *Segunda Iteración* ~

Enunciado:

https://docs.google.com/document/d/10j6XB9zIhl5xox2xBEDEFsgPmueHMkyvLSHcLxl_27Y/edit

Requerimientos:

- Especificar qué trama tiene la tela de una prenda.
- Crear una prenda especificando primero de qué tipo es.
- Crear una prenda especificando en segundo lugar los aspectos relacionados a su material (colores, material, trama, etc) para evitar elegir materiales inconsistentes con el tipo de prenda.
- Guardar un borrador de la la última prenda que empecé a cargar para continuar después.
- Poder no indicar ninguna trama para una tela, y que por defecto ésta sea lisa.
- Poder guardar una prenda solamente si esta es válida.

BONUS

- Poder recibir sugerencias de uniformes armados. 
- Quiero que un uniforme siempre conste de una prenda superior, una inferior y un calzado.
- Poder configurar diferentes uniformes para distintas instituciones.

Aclaraciones:

- Como el usuario no define la categoría a la que pertenece ni qué tipos de telas son válidos para construir un determinado tipo de prenda, es información que tiene que estar guardada en algún lado y que al momento de la creación de la prenda indique si la tela es apta para el tipo de prenda que se quiere crear. Además,el tipo de prenda no es la prenda en sí, sino que sólo guarda la información de a qué categoría pertenece y qué tipos de tela son inválidos para su construcción. Entonces, decidí tener atributos de clase ya que, si bien podrían cambiar a futuro, en general para todas las remeras, por ejemplo, voy a querer evitar que se cree una de cuero y no quiero estar redefiniendo eso cada vez que necesito instanciar una prenda. Por último, dejé la posibilidad de que se agregue o quite telas de la lista para posibles cambios futuros.
- Elijo usar Factory Method para la creación de uniformes porque me permite separar la construcción del uso y no necesito, al menos para los requerimientos actuales, la flexibilidad que me da el Abstract Method al permitirle a otros objetos utilizar al Sastre para construir uniformes. Como desventaja principal está el uso de herencia que genera más acoplamiento.
- Decidí crear una clase Material que tenga como atributos a la Tela y a la Trama (ambos son Enums) para evitar que el constructor de Prenda sea demasiado grande ya que a futuro podría llegar a agregarse más características.

~ *Cuarta Iteración* ~

Enunciado:

https://docs.google.com/document/d/1sy9S9EeIQr8fhatKnfTCgOfjVniJDu2viI-Av0gn0xY/edit

Requerimientos:

- Poder conocer las condiciones climáticas de Buenos Aires en un momento dado para obtener sugerencias acordes.
- Poder recibir sugerencias de atuendos que tengan una prenda para cada categoría, aunque a futuro podrán tener más.
- Al generar una sugerencia las prendas deben ser acordes a la temperatura actual sabiendo que para cada prenda habrá una temperatura hasta la cual es adecuada.
- Poder configurar fácilmente diferentes servicios de obtención del clima para ajustarme a las cambiantes condiciones económicas como administradore.
- Poder asegurar la calidad de mi aplicación sin incurrir en costos innecesarios como stakeholder.

Aclaraciones:

- TODO

~ *Quinta Iteración* ~

Enunciado:

https://docs.google.com/document/d/1wS622pMwZrDK9ilL_hEt5bBE04vKUKZILx8cIQ-aQzU/edit

Requerimientos:

- Poder manejar varios guardarropas para separar mis prendas según diversos criterios (ropa de viaje, ropa de entrecasa, etc) como usuarie. 
- Poder crear guardarropas compartidos con otros usuaries (ej, ropa que comparto con mi hermane). 
- Que otro usuario me proponga tentativamente agregar una prenda al guardarropas.
- Que otro usuario me proponga tentativamente quitar una prenda del guardarropas.
- Ver todas las propuestas de modificación (agregar o quitar prendas) del guardarropas y poder aceptarlas o rechazarlas.
- Poder deshacer las propuestas de modificación que haya aceptado.

Aclaraciones:

- Para poder manejar varios guardarropas, cree una clase Usuario la cual tiene una lista de guardarropas. Decidí no crear una interfaz Guardarropa y subclases por que por ahora no se sabe si cada guardarropa tiene un comportamiento en particular, todos van a tener una lista de prendas de acuerdo al tipo de guardarropa que sea.
- Para compartir un guardarropa con otro usuario, en la clase Usuario cree un método que recibe por parámetro el usuario y le agrega el guardarropas a su lista de guardarropas. Además, el usuario tiene 2 listas: Una lista con los guardarropas a los que tiene acceso (que le fueron compartidos) y una lista con los guardarropas propios, de esta forma cuando un usuario le hace una sugerencia a otro, se valida que compartan un guardarropas.
- Para ver las propuestas de modificación recibidas cree una lista de sugerencias en la clase Usuario. Las sugerencias las modelé como una Interfaz Sugerencia y 2 clases que implementan dicha interfaz: SugerenciaAgregar y SugerenciaQuitar.
- Las sugerencias tienen un estado. Al aceptar, rechazar o deshacer una sugerencia se le cambia dicho estado, de esta forma, para consultar cuales son las sugerencias en un determinado estado cree un método en la clase Usuario que filtran las sugerencias de la lista Sugerencias según determinado estado. Por otro lado, es la clase Sugerencia la cual entiende los mensajes aceptar, rechazar y deshacer.

~ *Sexta Iteración* ~

Enunciado: https://docs.google.com/document/d/1NxqhJj70kt-_4aw-CawlISdJZyedzoOcLAVJAZVZISE/edit#

Requerimientos:

Como usuario:

- Tener una sugerencia diaria de qué ponerme y que  todas las mañanas, diariamente, esta sea actualizada.
- Poder conocer cuáles son las últimas alertas meteorológicas publicadas en el sistema para estar informado (pudiendo verlas, por ejemplo, al entrar en quemepongo.com).
- Que se actualice mi sugerencia diaria con las condiciones climáticas actualizadas cuando se genere algún alerta durante el día.
- Tener la posibilidad de que ante una alerta de tormenta la app me notifique que debo llevarme también un paraguas.
- Que ante una alerta meteorológica de granizo la app  me notifique que evite salir en auto.
- Poder recibir un mail avisándome si se generó algún alerta meteorológico y cuál.
- Poder configurar cuáles de estas acciones (notificaciones, mail, recálculo)  quiero que se ejecuten y cuáles no, además de soportar nuevas acciones a futuro. (No nos interesará, sin embargo, soportar nuevas alertas).

Como empleado:

- Poder disparar el cálculo de sugerencias diarias para todos los usuarios para poder ejecutar esta acción a principio de cada día.
- Poder disparar un proceso que consulte y actualice la lista de alertas publicadas en el sistema para tener control sobre cuándo se publican las mismas.

Como administrador:

- Que las sugerencias diarias se calculen automáticamente sin que un empleado necesite disparar esta acción manualmente.
- Que las alertas se publiquen en el sitio automáticamente sin que un empleado necesite disparar esta acción manualmente.

Aclaraciones:

- Para que todos los usuarios reciban una sugerencia cada mañana de manera automática, cree una clase PlanificadorSugerenciaAtuendo la cual utiliza un timer para que todos los días a las 6 am ejecute el método sugerirAtuendoDiario que hace que el usuario ejecute haySugerenciaNueva, la cual se guarda dicha sugerencia en una lista. Decidí que sea una lista de sugerencias ya que para mi, el usuario al tener muchos guardarropas de diferentes estilos, habrá una sugerencia por cada guardarropa. No le llega una notificación a través de la app ya que en el enunciado no lo aclaraba.
- Por otro lado, también cree un PlanificadorAlerta el cual cada 5 minutos consulta las últimas alertas. Si hay nuevas alertas, actualiza el respositorio de alertas y da aviso al usuario (sólo si el usuario se suscribió a dicha notificación). El usuario tiene una lista de notificaciones preferentes, es decir, las acciones a las cuales el usuario se suscribió para recibir una notificación. Cada vez que hay alertas nuevas, el usuario dispara el método hayAlertasNuevas, el cual le delega a cada notificador enviar el aviso correspondiente, ya sea crear una sugerencia como notificar que hubo una alerta de tormenta o de granizo.
- Delegué la responsabilidad de enviar un mail o una notificación a una clase Alerta, la cual mediante su constructor se le indica que mensaje enviar. Es el notificador el que se encarga de instanciar dicha Alerta ya que primero verifica que en la lista de alertas qué tipo de alerta se dió.
