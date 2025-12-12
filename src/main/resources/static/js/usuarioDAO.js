export class UsuarioDAO {
    
    listaAlumnos() {
        throw new Error("listaAlumnos() debe ser implementado por la clase hija");
    }
    crearUsuario(usuario) {
        throw new Error("crearUsuario() debe ser implementado por la clase hija");
    }
    loginUsuario(usuario) {
        throw new Error("loginUsuario() debe ser implementado por la clase hija");
    }
    buscarPorCodigo(codigo) {
        throw new Error("buscarPorCodigo() debe ser implementado por la clase hija");
    }
    listaAlumnosConAsistenciaHoy() {
        throw new Error("listaAlumnosConAsistenciaHoy() debe ser implementado por la clase hija");
    }
}
