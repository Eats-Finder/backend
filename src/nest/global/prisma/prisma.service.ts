import { Injectable, Logger, OnModuleDestroy, OnModuleInit } from '@nestjs/common';
import { PrismaClient } from '@prisma/client';

@Injectable()
export class PrismaService extends PrismaClient implements OnModuleInit, OnModuleDestroy {
  public async onModuleInit() {
    try {
      await this.$connect();
    } catch (err) {
      Logger.error(err);
    }
  }

  public async onModuleDestroy() {
    try {
      await this.$disconnect();
    } catch (err) {
      Logger.error(err);
    }
  }
}
