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


