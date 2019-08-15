package br.com.agendaeletronica.service;

/*
 * Copyright 2007 Soren Davidsen, Tanesha Networks
 *  
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *    http://www.apache.org/licenses/LICENSE-2.0
 *    
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public class ReCaptchaException extends RuntimeException {

	private static final long serialVersionUID = -3975163868467332777L;

	public ReCaptchaException(String message) {
		super(message);
	}

	public ReCaptchaException(String message, Throwable t) {
		super(message, t);
	}

}
