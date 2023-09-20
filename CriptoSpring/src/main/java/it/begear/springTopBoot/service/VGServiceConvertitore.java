package it.begear.springTopBoot.service;

import org.springframework.stereotype.Service;

@Service
public class VGServiceConvertitore {

	    private double cambioEuro = 0.00003;//1Euro equivale a 0,00003Bitcoin
        private double cambioBitcoin= 45000;//1Bitcoin equivale a 45000Euro
        
	    public double conversioneEuroBitcoin(double quantitàEuro) {
	        return quantitàEuro * cambioEuro;
	    }

	    public double conversioneBitcoinEuro(double quantitàBitcoin) {
	        return quantitàBitcoin * cambioBitcoin;
	    }
	}

