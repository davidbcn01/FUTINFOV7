package com.example.futinfov2;

import java.util.ArrayList;
import java.util.List;

public class JugadoresRepositorio {
    List<Jugador> jugadores = new ArrayList<>();
    JugadoresRepositorio(){
        jugadores.add(new Jugador("Pelé","SD",91,"file:///android_asset/brasil2.png","file:///android_asset/escudo_icono.png","file:///android_asset/carapele.png","file:///android_asset/icono.png"));
        jugadores.add(new Jugador("Ronaldo","DC",94,"UK","file:///android_asset/escudo_icono.png","Link","file:///android_asset/icono.png"));
        jugadores.add(new Jugador("Eusebio","SD",89,"Link","file:///android_asset/escudo_icono.png","Link","file:///android_asset/icono.png"));
        jugadores.add(new Jugador("Pelé","SD",91,"Link","file:///android_asset/escudo_icono.png","Link","file:///android_asset/icono.png"));
        jugadores.add(new Jugador("Gullit","SD",90,"Link","file:///android_asset/escudo_icono.png","Link","file:///android_asset/icono.png"));
        jugadores.add(new Jugador("Cruyff","SD",91,"Link","file:///android_asset/escudo_icono.png","Link","file:///android_asset/icono.png"));
    }
    List<Jugador> obtener(){
        return jugadores;
    }
}
