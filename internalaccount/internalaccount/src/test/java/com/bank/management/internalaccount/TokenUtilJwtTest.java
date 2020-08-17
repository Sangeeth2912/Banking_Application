package com.bank.management.internalaccount;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.bank.management.internaldetails.utils.TokenUtilJwt;

@RunWith(MockitoJUnitRunner.class)
public class TokenUtilJwtTest 
{
@InjectMocks
TokenUtilJwt obj;

@Test
public void generateTokenTest()
{
//	Mockito.when(obj.generateToken(Mockito.anyString())).thenReturn("test");
	obj.generateToken("test");
}
}
