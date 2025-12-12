export class Usuario {
    constructor({
        id = 0,
        nombre = "",
        email = "",
        codigo = "",
        contrasena = "",
        fechaCreacion = new Date(),
        rol = null,
        estadoAsistencia = null,
        confirmarContrasena = ""
    } = {}) {

        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.codigo = codigo;
        this.contrasena = contrasena;
        this.fechaCreacion = fechaCreacion instanceof Date 
            ? fechaCreacion 
            : new Date(fechaCreacion);

        this.rol = rol;

        // No va a BD, igual que en Java
        this.estadoAsistencia = estadoAsistencia;

        // Campo temporal
        this.confirmarContrasena = confirmarContrasena;
    }


    // Getters y setters

    getId() { return this.id; }
    setId(id) { this.id = id; }

    getNombre() { return this.nombre; }
    setNombre(nombre) { this.nombre = nombre; }

    getEmail() { return this.email; }
    setEmail(email) { this.email = email; }

    getCodigo() { return this.codigo; }
    setCodigo(codigo) { this.codigo = codigo; }

    getContrasena() { return this.contrasena; }
    setContrasena(contrasena) { this.contrasena = contrasena; }

    getFechaCreacion() { return this.fechaCreacion; }
    setFechaCreacion(fecha) { 
        this.fechaCreacion = fecha instanceof Date ? fecha : new Date(fecha);
    }

    getRol() { return this.rol; }
    setRol(rol) { this.rol = rol; }

    getConfirmarContrasena() { return this.confirmarContrasena; }
    setConfirmarContrasena(valor) { this.confirmarContrasena = valor; }

    getEstadoAsistencia() { return this.estadoAsistencia; }
    setEstadoAsistencia(valor) { this.estadoAsistencia = valor; }
}
