/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endaycb.belajar.implement;

import com.endaycb.belajar.model.Buku;
import java.util.List;
/**
 *
 * @author mashiro
 */
public interface ImplementBuku {
    public List<Buku> getAll();
    public List<Buku> getByJudul(String judul);
    public Buku getById(Integer id);
    public void insert(Buku b);
    public void update(Buku b);
    public void delete(Integer id);
}
