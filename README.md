ejerc008
Descripción del Proyecto
El sistema gestiona Personas y Provincias, con la siguiente relación:

Una Provincia puede tener muchas Personas.
Una Persona pertenece a una única Provincia.

Funcionalidades Principales
- CRUD de Provincias: Crear, leer, actualizar.
- CRUD de Personas: Crear, leer, actualizar y eliminar Personas.
- Consultar Personas de una Provincia específica (/api/provincias/{id}/personas).
- Actualizar la Provincia de una Persona sin modificar la Provincia.

Reglas de Negocio

** Cuando se crea una Persona:
Se asigna una Provincia existente (no se crea ni modifica una Provincia).
Si la provinciaId = 0, la Persona no se guarda.

** Cuando se elimina una Persona:
No se elimina la Provincia.
Solo se borra la Persona.

** Cuando se consulta una Provincia:
No devuelve la lista de Personas directamente.
Se usa un endpoint adicional /api/provincias/{id}/personas.

**Cuando una Persona cambia de Provincia:
Se actualiza solo el provinciaId en la Persona.
No se modifica ni se crea una Provincia nueva.
