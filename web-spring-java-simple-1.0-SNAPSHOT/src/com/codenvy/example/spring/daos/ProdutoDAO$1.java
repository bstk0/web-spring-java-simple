/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  com.codenvy.example.spring.models.Produto
 *  com.google.firebase.database.DataSnapshot
 *  com.google.firebase.database.DatabaseError
 *  com.google.firebase.database.ValueEventListener
 */
package com.codenvy.example.spring.daos;

import com.codenvy.example.spring.daos.ProdutoDAO;
import com.codenvy.example.spring.models.Produto;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Semaphore;

class ProdutoDAO$1
implements ValueEventListener {
    final /* synthetic */ List val$listProd;
    final /* synthetic */ Semaphore val$semaphore;

    ProdutoDAO$1(List list, Semaphore semaphore) {
        this.val$listProd = list;
        this.val$semaphore = semaphore;
    }

    public void onDataChange(DataSnapshot dataSnapshot) {
    	System.out.println("$1.onDataChange");
        Iterable snapshotIterator = dataSnapshot.getChildren();
        Iterator iterator = snapshotIterator.iterator();
        while (iterator.hasNext()) {
            Produto prod = (Produto)((DataSnapshot)iterator.next()).getValue(Produto.class);
            System.out.println(prod.toString());
            this.val$listProd.add(prod);
        }
        System.out.println("semaphore.release()");
        this.val$semaphore.release();
    }

    public void onCancelled(DatabaseError arg0) {
    }
}