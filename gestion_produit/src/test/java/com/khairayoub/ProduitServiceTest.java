package com.khairayoub;

import com.khairayoub.Service.ProduitService;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProduitServiceTest {

    private ProduitService produitService;

    @Before
    public void setUp() {
        produitService = new ProduitService();
    }

    @Test
    public void testAjouterProduit() {
        Produit produit = new Produit(1L, "Produit Test", 100.0, 10);
        produitService.ajouterProduit(produit);
        assertEquals(produit, produitService.produits.get(1L));
    }


    @Test
    public void testGetProduit() {
        Produit found = produitService.getProduit(1L);
        assertNotNull(found);
        assertEquals("Produit Test", found.getNom());
    }
}
