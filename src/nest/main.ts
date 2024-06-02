import { NestFactory } from '@nestjs/core';
import { AppModule } from './app/app.module';
import { ConfigService } from '@nestjs/config';
import { DocumentBuilder, SwaggerCustomOptions, SwaggerModule } from '@nestjs/swagger';
import * as cookieParser from 'cookie-parser';

async function bootstrap() {
  const app = await NestFactory.create(AppModule);
  const configService = app.get(ConfigService);
  const PORT = configService.get<number>('PORT');

  app.use(cookieParser());

  const swaggerConfig = new DocumentBuilder()
    .setTitle('EatsFinder API')
    .setDescription('EatsFinder API 문서 입니다!')
    .addCookieAuth('accessToken')
    .build();

  const swaggerOptions: SwaggerCustomOptions = {
    swaggerOptions: {
      persistAuthorization: true,
    },
  };

  const swaggerDocument = SwaggerModule.createDocument(app, swaggerConfig);
  SwaggerModule.setup('docs', app, swaggerDocument, swaggerOptions);

  await app.listen(PORT);
  console.log(`🚀 http://localhost:${PORT}`);
}
bootstrap();
