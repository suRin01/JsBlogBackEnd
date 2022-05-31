package com.jsbird.jsblog.model;

import com.sun.istack.NotNull;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

   @NotNull
   private String username;

   @NotNull
   private String password;
}
