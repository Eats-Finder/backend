import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { ConfigModule } from '@nestjs/config';
import { PrismaModule } from '../global/prisma/prisma.module';

@Module({
  imports: [ConfigModule.forRoot({ envFilePath: `src/nest/global/env/.env`, isGlobal: true }), PrismaModule],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
