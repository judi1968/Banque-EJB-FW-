using Pret.Data;
using Pret.Models;
using Microsoft.EntityFrameworkCore;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace Pret.Services
{
    public class MontantPersonneService
    {
        private readonly AppDbContext _context;

        public MontantPersonneService(AppDbContext context)
        {
            _context = context;
        }

        public async Task<List<MontantPersonne>> GetAllMontantsAsync()
        {
            return await _context.MontantPersonne.ToListAsync();
        }

    }
}
