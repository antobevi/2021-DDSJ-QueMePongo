# 2021-DDSJ-QueMePongo

~ *Primera Iteración* ~

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

Requerimientos:

- Poder conocer las condiciones climáticas de Buenos Aires en un momento dado para obtener sugerencias acordes.
- Poder recibir sugerencias de atuendos que tengan una prenda para cada categoría, aunque a futuro podrán tener más.
- Al generar una sugerencia las prendas deben ser acordes a la temperatura actual sabiendo que para cada prenda habrá una temperatura hasta la cual es adecuada.
- Poder configurar fácilmente diferentes servicios de obtención del clima para ajustarme a las cambiantes condiciones económicas como administradore.
- Poder asegurar la calidad de mi aplicación sin incurrir en costos innecesarios como stakeholder.

Aclaraciones:

- Para conocer las condiciones climáticas de Buenos Aires en un momento dado cree una clase Pronosticador (que es un Singleton ya que sólo me interesa tener un único punto de acceso) la cual guarda en un atributo el servicio que utiliza y que puede cambiarse a futuro (falta arreglarlo en el código ya que no se cómo generalizarlo en el tipo de dato del atributo). 
Dentro de dicha clase cree un método consultarCondicionesClimaticasParaBsAs el cual no está terminado ya que tengo dudas sobre cómo implementarlo.
- Para sugerir un atuendo con una prenda por categoría cree una clase Guardarropa donde tiene una lista de atuendos y a la clase Prenda le puse como atributo una clase Temperatura, la cual tiene dos atributos: temperaturaMaxima y temperaturaMinima. De esa lista de atuendos primero filtra aquellos que tengan una prenda por categoría y luego para esos atuendos ve cuáles tienen todas sus prendas que sean para la temperatura que hace en el momento de sugerir el atuendo (le pedimos la temperatura al servicio climático y verificamos que esté entre temperaturaMaxima y temperaturaMinima).
Si a futuro los atuendos a sugerir pueden tener más de una prenda por categoría, entonces simplemente no debería filtrar aquellos atuendos con una prenda por categoría (método delegado en clase Atuendo que se encarga sólo de filtrar).
- Por otro lado, cree una clase Atuendo la cual tiene como atributo una lista de Prendas (falta validar que en la lista haya al menos una prenda por categoría y sólo una prenda de tipo calzado que no supe como hacerlo).
