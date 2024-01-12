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
        Produit produit = new Produit(1L, "Produit Test", 100.0, 10);
        produitService.ajouterProduit(produit);
        Produit found = produitService.getProduit(1L);
        assertNotNull(found);
        assertEquals("Produit Test", found.getNom());
    }


    @Test
    public void testMettreAJourProduit() {
        Produit produit = new Produit(1L, "Produit Test", 100.0, 10);

        produitService.ajouterProduit(produit);
        Produit updatedProduit = new Produit(1L, "Produit Modifié", 150.0, 5);
       
        produitService.mettreAJourProduit(1L, updatedProduit);
        Produit found = produitService.getProduit(1L);
        assertEquals("Produit Modifié", found.getNom());
        assertEquals(150.0, found.getPrix(), 0.0);
        assertEquals(5, found.getQuantite());
    }

    @Test
    public void testSupprimerProduit() {
        Produit produit = new Produit(1L, "Produit Test", 100.0, 10);

        produitService.ajouterProduit(produit);
        produitService.supprimerProduit(1L);
        assertNull(produitService.getProduit(1L));
    }

@Test(expected = IllegalArgumentException.class)
    public void testVerifierDonneesProduitPrixNegatif() {
        Produit produitInvalide = new Produit(2L, "Produit Invalide", -100.0, 10);
        produitService.ajouterProduit(produitInvalide);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testVerifierDonneesProduitQuantiteNegative() {
        Produit produitInvalide = new Produit(3L, "Produit Invalide", 100.0, -10);
        produitService.ajouterProduit(produitInvalide);
    }
    
}
