//package com.Taller1.Posteo.Repository;
//
//import com.Taller1.Posteo.Model.Posteo;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class PosteoRepository implements IposteoRepository{
//
//    private final List<Posteo> posteos = new ArrayList<>();
//
//    public PosteoRepository() {
//        posteos.add(new Posteo(1L,"Viaje en familia","Camila" ));
//        posteos.add(new Posteo(2L,"Cena en Crepes","Wilson" ));
//    }
//
//    @Override
//    public List<Posteo> findAll() {
//        return posteos;
//    }
//
//    @Override
//    public Posteo findById(Long id) {
//        for (Posteo pos: posteos){
//            if (pos.getId_posteo().equals(id)){
//                return pos;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void save(Posteo posteo) {
//        posteos.add(posteo);
//    }
//}
