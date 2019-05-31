package com.padawans.wrapper.contracts.utils;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.json.GsonJsonParser;
import org.web3j.crypto.WalletFile;
import org.web3j.crypto.WalletFile.CipherParams;
import org.web3j.crypto.WalletFile.Crypto;
import org.web3j.crypto.WalletFile.ScryptKdfParams;

import com.padawans.wrapper.contracts.exceptions.WalletMapperException;

public class WalletMapper {

	private static final Log log = LogFactory.getLog(WalletMapper.class);

	public static WalletFile getWallet(String jsonWallet) {
		try {
			GsonJsonParser gson = new GsonJsonParser();
			Map<String, Object> walletdata = gson.parseMap(jsonWallet);
			Map<String, Object> cryptoData = gson.parseMap(walletdata.get("crypto").toString());
			Map<String, Object> kdfparamsData = gson.parseMap(cryptoData.get("kdfparams").toString());
			Map<String, Object> cipherParamsData = gson.parseMap(cryptoData.get("cipherparams").toString());
			CipherParams cipherParams = new CipherParams();
			cipherParams.setIv((String)cipherParamsData.get("iv"));
			ScryptKdfParams aes = new ScryptKdfParams();
			aes.setSalt((String)kdfparamsData.get("salt"));
			
			aes.setDklen((int)(double)kdfparamsData.get("dklen"));
			aes.setN((int)(double)kdfparamsData.get("n"));
			aes.setP((int)(double)kdfparamsData.get("p"));
			aes.setR((int)(double)kdfparamsData.get("r"));
			Crypto crypto = new Crypto();
			crypto.setCipher((String) cryptoData.get("cipher"));
			crypto.setCipherparams(cipherParams);
			crypto.setKdfparams(aes);
			crypto.setCiphertext((String) cryptoData.get("ciphertext"));
			crypto.setKdf((String) cryptoData.get("kdf"));
			crypto.setMac((String) cryptoData.get("mac"));
			//crypto.setKdfparams(kdfparams);
			WalletFile file = new WalletFile();
			file.setAddress((String) walletdata.get("address"));
			file.setCrypto(crypto);
			file.setId((String) walletdata.get("id"));
			file.setVersion((int)(double) walletdata.get("version"));
			return file;
			
		} catch (Exception e) {
			log.error("WalletSerializerException "+e);
			throw new WalletMapperException(e.getMessage());
		}
		
	}
	
	
}
