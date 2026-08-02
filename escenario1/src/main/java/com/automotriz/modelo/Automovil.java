package com.automotriz.modelo;

/**
 * Representa la entidad de dominio de un Automóvil personalizado.
 * <p>
 * Esta clase es <strong>inmutable</strong> y no expone métodos modificadores (setters).
 * Su construcción se delega exclusivamente a la clase interna {@link AutomovilBuilder} 
 * para resolver el problema del constructor telescópico y garantizar un estado válido.
 * </p>
 *
 * @author Equipo de Arquitectura
 * @version 1.0
 * @see AutomovilBuilder
 */
public final class Automovil {

	/** Tipo y especificación del motor (Campo Requerido). */
    private final String motor;

    /** Color exterior del vehículo (Campo Requerido). */
    private final String color;

    /** Tipo y tamaño de las llantas (Opcional). */
    private final String llantas;

    /** Marca o especificación del sistema de audio (Opcional). */
    private final String sistemaSonido;

    /** Material y acabado de los interiores (Opcional). */
    private final String interiores;

    /** Indica si el vehículo incluye techo solar (Opcional). */
    private final boolean techoSolar;

    /** Indica si el vehículo incluye sistema de navegación GPS (Opcional). */
    private final boolean navegacionGPS;
    
    /**
     * Constructor privado accesible únicamente por el {@link AutomovilBuilder}.
     * Asigna el estado inmutable del objeto a partir de los valores configurados en el builder.
     *
     * @param builder Instancia del constructor que contiene los parámetros de configuración.
     */
    private Automovil(AutomovilBuilder builder) {
        this.motor = builder.motor;
        this.color = builder.color;
        this.llantas = builder.llantas;
        this.sistemaSonido = builder.sistemaSonido;
        this.interiores = builder.interiores;
        this.techoSolar = builder.techoSolar;
        this.navegacionGPS = builder.navegacionGPS;
    }
    
    public String getMotor() { return motor; }
    public String getColor() { return color; }
    public String getLlantas() { return llantas; }
    public String getSistemaSonido() { return sistemaSonido; }
    public String getInteriores() { return interiores; }
    public boolean isTechoSolar() { return techoSolar; }
    public boolean isNavegacionGPS() { return navegacionGPS; }

    /**
     * Retorna una representación en texto del estado actual del automóvil.
     * Muestra valores por defecto amigables para los atributos opcionales que no fueron configurados.
     *
     * @return Cadena formateada con la ficha técnica del vehículo.
     */
    @Override
    public String toString() {
        return "Automovil [" +
                "motor='" + motor + '\'' +
                ", color='" + color + '\'' +
                ", llantas='" + (llantas != null ? llantas : "Estándar") + '\'' +
                ", sistemaSonido='" + (sistemaSonido != null ? sistemaSonido : "Básico") + '\'' +
                ", interiores='" + (interiores != null ? interiores : "Tela") + '\'' +
                ", techoSolar=" + techoSolar +
                ", navegacionGPS=" + navegacionGPS +
                ']';
    }
    
    /**
     * Builder para facilitar la creación paso a paso de objetos {@link Automovil}.
     * Implementa el patrón Fluent API para mejorar la legibilidad del código.
     */
    public static class AutomovilBuilder {
    	
        private final String motor;
        private final String color;
        
        private String llantas;
        private String sistemaSonido;
        private String interiores;
        private boolean techoSolar;
        private boolean navegacionGPS;
        
        /**
         * Inicializa el Builder con los atributos estrictamente obligatorios.
         *
         * @param motor Especificación del motor (no puede ser {@code null} ni vacío).
         * @param color Color del automóvil (no puede ser {@code null} ni vacío).
         * @throws IllegalArgumentException Si 'motor' o 'color' son nulos o están vacíos.
         */
        public AutomovilBuilder(String motor, String color) {
            if (motor == null || color == null) {
                throw new IllegalArgumentException("Motor y color son campos requeridos.");
            }
            this.motor = motor;
            this.color = color;
        }
        
        /**
         * Configura las llantas del vehículo.
         *
         * @param llantas Descripción o especificación de las llantas.
         * @return La misma instancia de {@link AutomovilBuilder} para encadenamiento.
         */
        public AutomovilBuilder llantas(String llantas) {
            this.llantas = llantas;
            return this;
        }

        /**
         * Configura el sistema de sonido del vehículo.
         *
         * @param sistemaSonido Especificación del sistema de audio.
         * @return La misma instancia de {@link AutomovilBuilder} para encadenamiento.
         */
        public AutomovilBuilder sistemaSonido(String sistemaSonido) {
            this.sistemaSonido = sistemaSonido;
            return this;
        }

        /**
         * Configura el tipo de interiores del vehículo.
         *
         * @param interiores Materiales/acabados del interior.
         * @return La misma instancia de {@link AutomovilBuilder} para encadenamiento.
         */
        public AutomovilBuilder interiores(String interiores) {
            this.interiores = interiores;
            return this;
        }

        /**
         * Configura la inclusión de techo solar.
         *
         * @param techoSolar {@code true} para incluir techo solar.
         * @return La misma instancia de {@link AutomovilBuilder} para encadenamiento.
         */
        public AutomovilBuilder techoSolar(boolean techoSolar) {
            this.techoSolar = techoSolar;
            return this;
        }

        /**
         * Configura la inclusión de sistema de navegación GPS.
         *
         * @param navegacionGPS {@code true} para incluir GPS.
         * @return La misma instancia de {@link AutomovilBuilder} para encadenamiento.
         */
        public AutomovilBuilder navegacionGPS(boolean navegacionGPS) {
            this.navegacionGPS = navegacionGPS;
            return this;
        }
        
        /**
         * Construye e instancia el objeto {@link Automovil} con las configuraciones definidas.
         *
         * @return Una instancia inmutable de {@link Automovil}.
         */
        public Automovil build() {
            return new Automovil(this);
        }
    }
}
